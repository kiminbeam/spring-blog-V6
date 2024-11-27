package com.metacoding.authblog.user;

import lombok.Data;

public class UserRequest {

    @Data
    public static class loginDTO{
        private String username;
        private String password;

        // insert 할게 아니라서 toEntity 안만든다.
    }
}
