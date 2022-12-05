package com.openapi.weather.repository;

import com.openapi.weather.domain.Member;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;


@DataJpaTest
class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    void 멤버생성(){
        Member member = Member.builder()
                .email("11@naver.com")
                .build();

        Member savedMember = memberRepository.save(member);

        assertEquals(savedMember.getId(), member.getId());
        assertEquals(0, member.getImages().size());
    }

    @Test
    void 중복멤버(){
        Member member1 = Member.builder()
                .email("11@naver.com")
                .build();

        memberRepository.save(member1);

        Member member2 = Member.builder()
                .email("11@naver.com")
                .build();

        memberRepository.findByEmail(member2.getEmail()).orElseThrow(() -> new IllegalArgumentException("중복된 이메일이 존재합니다"));


    }

}