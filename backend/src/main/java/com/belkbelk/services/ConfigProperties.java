package com.belkbelk.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ConfigProperties {

    @Value("${ebayApiTemplate}")
    private String ebayApiTemplate;

    @Value("${apiToken}")
    private String apiToken;

    public String getEbayApiTemplate() {
        return ebayApiTemplate;
    }

    public String getApiToken() {
        return "Bearer " + apiToken;
    }

}
