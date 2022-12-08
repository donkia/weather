package com.openapi.weather.repository;

import com.openapi.weather.domain.Weather;
import com.openapi.weather.domain.WeatherID;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import java.time.LocalDate;
import java.util.Optional;

@DataJpaTest
class WeatherRepositoryTest {

    @Autowired
    WeatherRepository weatherRepository;

    public WeatherID makeWeatherID(){
        return WeatherID.builder()
                .nx("55")
                .ny("127")
                .baseDate(LocalDate.now().toString())
                .category("category")
                .build();
    }

    public Weather makeWeather(String fcstValue){
        return Weather.builder()
                .fcstValue(fcstValue)
                .weatherID(makeWeatherID())
                .build();
    }

    @Test
    void 데이터저장(){
        Weather weather = makeWeather("10");
        Weather savedWeather = weatherRepository.save(weather);

        Assertions.assertEquals("10", savedWeather.getFcstValue());
        Assertions.assertEquals("55", savedWeather.getWeatherID().getNx());
    }

    @Test
    void 날씨데이터_중복확인(){
        Weather weather = makeWeather("10");
        weatherRepository.save(weather);

        Weather weather1 = makeWeather("20");
        weatherRepository.save(weather1);

        Optional<Weather> savedWeather = weatherRepository.findById(weather1.getWeatherID());

        if(savedWeather.isPresent())
            Assertions.assertEquals("20", savedWeather.get().getFcstValue());
    }


}