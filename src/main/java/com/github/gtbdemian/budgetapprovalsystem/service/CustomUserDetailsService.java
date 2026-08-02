package com.github.gtbdemian.budgetapprovalsystem.service;

import com.github.gtbdemian.budgetapprovalsystem.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Spring Security 인증 처리를 위한 UserDetailsService 구현체
 *
 * UserService에 Spring Security 코드를 섞으면 응집도가 낮아지고 결합도가 높아지므로,
 * 인증 역할을 별도 클래스로 분리하여 각 클래스가 단일 책임을 갖도록 설계하였습니다.
 *
 * Spring Security는 로그인 요청 시 UserDetailsService를 구현한 클래스를 찾아
 * loadUserByUsername()을 자동으로 호출합니다.
 */
@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    /**
     * 사번으로 사용자를 조회하여 Spring Security의 UserDetails 객체로 반환합니다.
     * Spring Security의 기본 식별자인 username 대신 사번을 사용하여 인증합니다.
     */
    @Override
    public UserDetails loadUserByUsername(String employNumber) throws UsernameNotFoundException {

        System.out.println("로그인 시도 비번: " + employNumber);
        User user = userService.findByEmployeeNumber(employNumber);
        System.out.println("조회된 유저: " + user);

        if (user == null) {
            throw new UsernameNotFoundException("사번을 찾을 수 없습니다: " + employNumber);
        }

        // ROLE_접두사는 Spring Security의 권한 규칙에 따라 필수로 붙여야 합니다.
        // 예: EMPLOYEE -> ROLE_EMPLOYEE
        return new org.springframework.security.core.userdetails.User(
                user.getEmployeeNumber(),
                user.getPassword(),
                List.of(new SimpleGrantedAuthority("ROLE_" +user.getRole()))
        );
    }
}
