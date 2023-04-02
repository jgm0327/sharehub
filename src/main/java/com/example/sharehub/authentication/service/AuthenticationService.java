package com.example.sharehub.authentication.service;

import com.example.sharehub.authentication.dto.JoinDTO;
import com.example.sharehub.member.mapper.MemberMapper;
import com.example.sharehub.member.repository.MemberRepository;
import com.example.sharehub.status.authentication.Join;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticationService {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public int join(JoinDTO joinDTO) {
        //BcryptEncoder 로 비밀번호 암호화
        joinDTO.setPassword(passwordEncoder.encode(joinDTO.getPassword()));
        joinDTO.setRole("ROLE_USER");
        //이상 없다면 저장 후 성공 StatusCode 반환
        memberRepository.save(MemberMapper.INSTANCE.JoinDTOtoEntity(joinDTO));
        return Join.SUCCESS.getStatus();
    }

    // 아이디 중복 체크
    public int checkUserId(String userId) {
        // 있으면 중복
        if (memberRepository.findByUsername(userId).isPresent()) {
            return Join.REDUNDANT_ID.getStatus();
        }
        // 없으면 중고 X
        return Join.SUCCESS.getStatus();
    }

    // 닉네임 중복 체크
    public int checkNick(String nickname) {
        // 있으면 중복
        if (memberRepository.findByNickname(nickname).isPresent()) {
            return Join.REDUNDANT_NICKNAME.getStatus();
        }
        // 없으면 중복 X
        return Join.SUCCESS.getStatus();
    }
}
