package com.metacoding.authblog.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepo;

    public User 로그인(UserRequest.loginDTO loginDTO) {
        User userPS = userRepo.findByUsername(loginDTO.getUsername());
        if (!userPS.getPassword().equals(loginDTO.getPassword())) {
            throw new RuntimeException("아이디 혹은 패스워드가 일치하지 않습니다.");
            //로그를 남겨서 서버에 패스워드가 실패 카운팅
        }
        return userPS;
    }
}
