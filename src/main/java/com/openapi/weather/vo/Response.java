package com.openapi.weather.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@Data
public class Response {

    Header header;
    Body body;
}
