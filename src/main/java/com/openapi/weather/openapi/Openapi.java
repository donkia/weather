package com.openapi.weather.openapi;

import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public interface Openapi {

    public URL setURL() throws UnsupportedEncodingException, MalformedURLException, URISyntaxException;
    public void getData() throws UnsupportedEncodingException, MalformedURLException, URISyntaxException;
}
