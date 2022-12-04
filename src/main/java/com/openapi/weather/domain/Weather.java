package com.openapi.weather.domain;

import com.openapi.weather.vo.Item;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
@Getter
public class Weather extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    String baseDate;
    String baseTime;
    String category;
    String fcstDate;
    String fcstTime;
    String fcstValue;
    String nx;
    String ny;


    @Builder
    Weather(String baseDate, String baseTime, String category, String fcstDate, String fcstTime, String fcstValue, String nx, String ny){
        this.baseDate = baseDate;
        this.baseTime = baseTime;
        this.category = category;
        this.fcstDate = fcstDate;
        this.fcstTime = fcstTime;
        this.fcstValue = fcstValue;
        this.nx = nx;
        this.ny = ny;
    }

    public Weather() {

    }

    public static Weather convertItemToWeather(Item item){
        return Weather.builder()
                .baseDate(item.getBaseDate())
                .baseTime(item.getBaseTime())
                .category(item.getCategory())
                .fcstDate(item.getFcstDate())
                .fcstTime(item.getFcstTime())
                .fcstValue(item.getFcstValue())
                .nx(item.getNx())
                .ny(item.getNy())
                .build();
    }
}
