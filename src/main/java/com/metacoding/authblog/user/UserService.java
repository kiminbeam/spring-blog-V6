package com.metacoding.authblog.user;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService implements UserDetailsService {
    private final UserRepository userRepo;

    private final PasswordEncoder passwordEncoder;

    // POST 요청
    // login 일때 호출됨
    // key 값 -> username, password
    // Content-type = x-www-urlencoded
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepo.findByUsername(username);
        return user;
    }

    @Transactional
    public void 회원가입(UserRequest.JoinDTO joinDTO){
        userRepo.save(joinDTO.toEntity(passwordEncoder));
    }
}
