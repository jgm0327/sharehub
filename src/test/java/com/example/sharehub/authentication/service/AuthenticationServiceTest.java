package com.example.sharehub.authentication.service;

import com.example.sharehub.authentication.dto.JoinDTO;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class AuthenticationServiceTest {

    @Autowired
    AuthenticationService authenticationService;

    @Test
    @Disabled
    @DisplayName("회원 가입 테스트")
    void testJoin() {
        assertThat(authenticationService.join(JoinDTO.builder()
                .username("testuser2")
                .nickname("testnick2")
                .password("123123123")
                .build())).isNotNull().isEqualTo(201);
    }

    @Test
    @DisplayName("아이디 중복 체크 - 성공 시")
    void testCheckIdSuccess() {
        assertThat(authenticationService.checkUserId("testuser10"))
                .isNotNull()
                .isEqualTo(201);
    }

    @Test
    @DisplayName("아이디 중복 체크 - 중복 시")
    void testCheckIdFail() {
        assertThat(authenticationService.checkUserId("testuser2"))
                .isNotNull()
                .isEqualTo(202);
    }

    @Test
    @DisplayName("닉네임 중복 체크 - 중복 시")
    void testCheckNickFail() {
        assertThat(authenticationService.checkNick("testnick2"))
                .isNotNull()
                .isEqualTo(203);
    }

    @Test
    @DisplayName("닉네임 중복 체크 - 성공 시")
    void testCheckNickSuccess() {
        assertThat(authenticationService.checkNick("nickname100"))
                .isNotNull()
                .isEqualTo(201);
    }
}