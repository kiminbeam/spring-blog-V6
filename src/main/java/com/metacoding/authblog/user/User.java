package com.metacoding.authblog.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.sql.Timestamp;
import java.util.Collection;
import java.util.List;

@Entity
@Table (name = "user_tb")
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String username; //아이디

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @CreationTimestamp
    private Timestamp createdAt;

    public String geteUsername() {
        return username;
    }

    public String getePassword() {
        return password;
    }


    // 사용자 권한 (role)
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    // 계정 만료되지 않았는지 확인 ( 만료 = 휴면
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    // 계정이 잠겨있는지,아닌지 확인
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    // 인증 자격 증명(비밀번호 만료 확인)
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    // 계정 활성화 상태 확인 (계정 정지 on/off)
    @Override
    public boolean isEnabled() {
        return true;
    }
}
