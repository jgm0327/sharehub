package com.example.sharehub.member.repository;

import com.example.sharehub.member.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void test(){
        Member member = memberRepository.findByUsername("testuser1").orElse(null);
        assertThat(member).isNotNull();
        System.out.println(member.getPassword());
    }

}