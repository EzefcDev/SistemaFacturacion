package com.example.sistemafacturacion.util;

import com.example.sistemafacturacion.dto.WorldClockDto;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WorldClockRestApi {

    public WorldClockDto getcurrentDateTime() {
        RestTemplate restTemplate = new RestTemplate();
        final String url = "http://worldclockapi.com/api/json/est/now";
        return restTemplate.getForObject(url, WorldClockDto.class);
    }
}
