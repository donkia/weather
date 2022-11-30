package com.openapi.weather.repository;

import com.openapi.weather.domain.Weather;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

@DataJpaTest
class WeatherRepositoryTest {

    @Autowired
    WeatherRepository weatherRepository;

    public Weather makeWeather(){
        return Weather.builder()
                .baseDate(LocalDate.now().toString())
                .category("")
                .fcstDate(LocalDate.now().toString())
                .fcstValue("1")
                .nx("55")
                .ny("127")
                .build();
    }

    @Test
    void 데이터저장(){
        Weather weather = makeWeather();
        Weather savedWeather = weatherRepository.save(weather);

        Assertions.assertEquals("55", savedWeather.getNx());
    }


}