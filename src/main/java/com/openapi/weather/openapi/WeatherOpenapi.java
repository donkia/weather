package com.openapi.weather.openapi;

import com.openapi.weather.vo.ResponseDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;

public class WeatherOpenapi implements Openapi {

    @Value("${openapi.serviceKey}")
    private String serviceKey;

    @Override
    public URL setURL() throws UnsupportedEncodingException, MalformedURLException {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1360000/VilageFcstInfoService_2.0/getVilageFcst"); /*URL*가Dto.toString());
    }
}
