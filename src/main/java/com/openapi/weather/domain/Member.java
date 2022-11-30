package com.openapi.weather.domain;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Member extends BaseTimeEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    private String email;

    @OneToMany(mappedBy = "member")
    private List<Image> images = new ArrayList<>();

    @Builder
    public Member(String email){
        this.email = email;
    }


    public Member() {

    }
}
