package com.metacoding.authblog.user;

import lombok.Data;
import org.springframework.security.crypto.password.PasswordEncoder;

public class UserRequest {

    @Data
    public static class loginDTO{
        private String username;
        private String password;

        // insert 할게 아니라서 toEntity 안만든다.
    }

    @Data
    public class JoinDTO {
        private String username;
        private String password;
        private String email;

        public User toEntity(PasswordEncoder passwordEncoder){
            String encPassword = passwordEncoder.encode(password);

            System.out.println("password: " + encPassword);

            User user = new User(null ,username, encPassword, email, null);
            return user;
        }
    }
}
