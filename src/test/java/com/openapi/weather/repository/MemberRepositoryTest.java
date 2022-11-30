package com.openapi.weather.repository;

import com.openapi.weather.domain.Member;
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

}