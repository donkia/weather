package com.openapi.weather.service;

import com.openapi.weather.domain.Weather;
import com.openapi.weather.openapi.WeatherOpenapi;
import com.openapi.weather.repository.WeatherRepository;
import com.openapi.weather.vo.Item;
import com.openapi.weather.vo.ResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final WeatherOpenapi weatherOpenapi;

    @Scheduled(cron = "10 * * * * ?")
    private void getOpenapiWeather() throws MalformedURLException, UnsupportedEncodingException, URISyntaxException {
        ResponseDto responseDto = weatherOpenapi.getData();

        if(responseDto.getResponse().getHeader().getResultCode().equals("00")){
            List<Item> items = responseDto.getResponse().getBody().getItems().item;

            for(Item item : items){
                weatherRepository.save(Weather.convertItemToWeather(item));
            }
        }
    }

}
