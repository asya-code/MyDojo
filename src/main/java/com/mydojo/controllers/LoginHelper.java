package com.mydojo.controllers;

import com.mydojo.services.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginHelper {
    @Autowired
    private UserService userService;

    public String getLoggedInUser(HttpSession session) {
        return (String) session.getAttribute("signed_user");
    }

    public boolean isUserAdminOrCoach(HttpSession session) {
        return isUserAdmin(session) || isUserCoach(session);
    }

    public boolean isUserAdmin(HttpSession session) {
        Boolean result = (Boolean) session.getAttribute("is_admin");
        return (result != null ? result : false);
    }

    public boolean isUserCoach(HttpSession session) {
        Boolean result = (Boolean) session.getAttribute("is_coach");
        return (result != null ? result : false);
    }

    public ResponseEntity<?> createLoginRedirect() {
        return createResponse("logged_out", "");
    }

    public ResponseEntity<?> createUnauthorizedResponse() {
        return createResponse("unauthorized", "");
    }

    public ResponseEntity<?> createResponse(List<?> list) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Object obj : list) {
            if (sb.length() != 1) {
                sb.append(", ");
            }
            sb.append(obj.toString());
        }
        sb.append("]");
        return createResponse("ok", sb.toString());
    }

    public ResponseEntity<?> createResponse(Optional<?> dto) {
        return createResponse(
                "ok",
                (dto.isPresent() && dto.get() != null ? dto.get().toString(): ""));
    }

    private ResponseEntity<?> createResponse(String status, String data) {
        HttpHeaders responseHeaders = new HttpHeaders();
        ResponseEntity<String> result = new ResponseEntity<>(
                "{ \"status\": \"" + status + "\", \"data\": " + data + " }",
                responseHeaders,  HttpStatus.OK);
        return result;
    }
}
