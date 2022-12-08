package com.openapi.weather.repository;

import com.openapi.weather.domain.Weather;
import com.openapi.weather.domain.WeatherID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends CrudRepository<Weather, WeatherID> {


}
