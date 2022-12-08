package com.openapi.weather.domain;

import lombok.*;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter
@ToString
@NoArgsConstructor
public class WeatherID implements Serializable {



    String baseDate;

    String baseTime;

    String category;

    String fcstDate;

    String fcstTime;

    String nx;

    String ny;

    @Builder
    WeatherID(String baseDate, String baseTime, String category, String fcstDate, String fcstTime, String nx, String ny){
        this.baseDate = baseDate;
        this.baseTime = baseTime;
        this.category = category;
        this.fcstDate = fcstDate;
        this.fcstTime = fcstTime;
        this.nx = nx;
        this.ny = ny;
    }

}
