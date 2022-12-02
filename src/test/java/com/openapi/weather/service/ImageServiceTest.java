package com.openapi.weather.service;

import com.openapi.weather.domain.Image;
import com.openapi.weather.domain.Member;
import com.openapi.weather.repository.ImageRepository;
import com.openapi.weather.repository.MemberRepository;
import com.openapi.weather.vo.Item;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

//@DataJpaTest
@SpringBootTest
class ImageServiceTest {

    @Autowired
    FileService fileService;

    @Autowired
    ImageRepository imageRepository;

    @Autowired
    MemberRepository memberRepository;

    private MockMultipartFile createMultipartFile(){

        String path = "/Users/kimbyeonghyeon";
        String imageName = "image.jpg";
        MockMultipartFile multipartFile = new MockMultipartFile(path, imageName, "image/jpg", new byte[]{1, 2, 3, 4});

        return multipartFile;
    }

    @Test
    void 이미지저장() throws IOException {
        Member member = new Member("11@11.com");
        memberRepository.save(member);

        MultipartFile multipartFile = createMultipartFile();
        String fileName = fileService.uploadFile(multipartFile.getName(), multipartFile.getOriginalFilename(), multipartFile.getBytes());

        Image image = Image.builder()
                .fileName(fileName)
                .fileOriName(multipartFile.getOriginalFilename())
                .fileUrl("/images/" + fileName)
                .member(member)
                .build();


        Image savedImage = imageRepository.save(image);

        Assertions.assertEquals(fileName, savedImage.getFileName());
    }

}