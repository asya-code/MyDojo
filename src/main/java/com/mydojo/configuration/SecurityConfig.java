package com.mydojo.configuration;

//import com.mydojo.dtos.UserDto;
//import com.mydojo.services.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//import java.util.ArrayList;
//import java.util.Collection;
//import java.util.Optional;

//@Configuration
//@ComponentScan(basePackages = { "com.baeldung.security" })
//@EnableWebSecurity
public class SecurityConfig {
//    @Autowired
//    private UserService userService;
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//    @Bean
//    public DaoAuthenticationProvider authProvider() {
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
//        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider() {
//            @Override
//            public Authentication authenticate(Authentication authentication) throws AuthenticationException {
//                UserDto user = new UserDto();
//                user.setEmail(authentication.getName());
//                user.setPassword("abc");
//                UserDetailsImpl details = new UserDetailsImpl(user);
//                UsernamePasswordAuthenticationToken result = UsernamePasswordAuthenticationToken.authenticated(
//                        new Object(), authentication.getCredentials(), details.getAuthorities());
//                result.setDetails(authentication.getDetails());
//                this.logger.error("Authenticated user");
//                return result;
//            }
//        };
//        authProvider.setUserDetailsService(new UserDetailsServiceImpl());
//        authProvider.setPasswordEncoder(passwordEncoder);
//        return authProvider;
//    }
//
//    @Bean
//    public AuthenticationManager authManager(HttpSecurity http) throws Exception {
//        return http.getSharedObject(AuthenticationManagerBuilder.class)
//                .authenticationProvider(authProvider())
//                .build();
//    }
//
//    private class UserDetailsServiceImpl implements UserDetailsService {
//        @Override
//        public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//            Optional<UserDto> userOptional = userService.findByEmail(username);
//            if (!userOptional.isPresent()) {
//                throw new UsernameNotFoundException("User not found");
//            }
//
//            return new UserDetailsImpl(userOptional.get());
//        }
//    }
//
//    private static class Authority implements GrantedAuthority {
//        String name;
//
//        Authority(String name) {
//            this.name = name;
//        }
//
//        @Override
//        public String getAuthority() {
//            return name;
//        }
//    }
//
//    private static class UserDetailsImpl implements UserDetails {
//        private UserDto user;
//
//        UserDetailsImpl(UserDto user) {
//            this.user = user;
//        }
//
//        @Override
//        public Collection<? extends GrantedAuthority> getAuthorities() {
//            ArrayList<Authority> result = new ArrayList<>();
//            if (user.getIsAdmin()) {
//                result.add(new Authority("admin"));
//            }
//            return result;
//        }
//
//        @Override
//        public String getPassword() {
//            return user.getPassword();
//        }
//
//        @Override
//        public String getUsername() {
//            return user.getEmail();
//        }
//
//        @Override
//        public boolean isAccountNonExpired() {
//            return false;
//        }
//
//        @Override
//        public boolean isAccountNonLocked() {
//            return true;
//        }
//
//        @Override
//        public boolean isCredentialsNonExpired() {
//            return true;
//        }
//
//        @Override
//        public boolean isEnabled() {
//            return true;
//        }
//    }
}
