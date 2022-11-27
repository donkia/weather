package com.openapi.weather.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Data
public class Body {

    public String dataType;
    public Items items;
    public Integer pageNo;
    public Integer numOfRows;
    public Integer totalCount;


}
