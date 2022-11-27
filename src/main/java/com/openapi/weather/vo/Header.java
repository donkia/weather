package com.openapi.weather.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class Header {
    String resultCode;
    String resultMsg;
}
