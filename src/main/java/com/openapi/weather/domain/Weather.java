package com.openapi.weather.domain;

import com.openapi.weather.vo.Item;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Getter
@EntityListeners(AuditingEntityListener.class)
public class Weather extends BaseTimeEntity implements Serializable {

    @EmbeddedId
    @Column(name="weahter_id")
    private WeatherID weatherID;

    String fcstValue;


    @Builder
    Weather(WeatherID weatherID, String fcstValue){
        this.weatherID = weatherID;
        this.fcstValue = fcstValue;
    }

    public Weather() {

    }

    public void setFcstValue(String fcstValue){
        this.fcstValue = fcstValue;
    }

    public static Weather convertItemToWeather(Item item){
        WeatherID weatherID = WeatherID.builder()
                .baseDate(item.getBaseDate())
                .baseTime(item.getBaseTime())
                .category(item.getCategory())
                .fcstDate(item.getFcstDate())
                .fcstTime(item.getFcstTime())
                .nx(item.getNx())
                .ny(item.getNy())
                .build();

        return Weather.builder()
                .weatherID(weatherID)
                .fcstValue(item.getFcstValue())
                .build();
    }
}
