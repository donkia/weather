package com.openapi.weather.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Weather {

    String baseDate;
    String baseTime;
    String category;
    String fcstDate;
    String fcstTime;
    String fcstValue;
    String nx;
    String ny;

}
