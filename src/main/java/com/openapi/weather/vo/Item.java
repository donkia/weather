package com.openapi.weather.vo;


import lombok.Data;

@Data
public class Item {

    String baseDate;
    String baseTime;
    String category;
    String fcstDate;
    String fcstTime;
    String fcstValue;
    String nx;
    String ny;

}
