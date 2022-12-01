package com.openapi.weather.service;

import com.openapi.weather.repository.ImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ImageService {

    private final FileService fileService;
    private final ImageRepository imageRepository;


}
