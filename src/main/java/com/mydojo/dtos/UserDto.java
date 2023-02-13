package com.mydojo.dtos;

import com.mydojo.entites.User;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto implements Serializable {
    private Long id;
    private String email;
    private String password;
    private Boolean isAdmin;

    public UserDto(User src) {
        if (src.getId() != null) {
            this.id = src.getId();
        }

        if (src.getEmail() != null) {
            this.email = src.getEmail();
        }

        if (src.getPassword() != null) {
            this.password = src.getPassword();
        }

        if (src.getIsAdmin() != null) {
            this.isAdmin = src.getIsAdmin();
        }
    }
}
