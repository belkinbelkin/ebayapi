package com.belkbelk.services;

import com.belkbelk.abstractclasses.AbstractDataSource;
import com.belkbelk.datastructures.EbayApiSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

@Service("apiService")
public class EbayApiDataSource extends AbstractDataSource {

    @Autowired
    ConfigProperties configProperties;

    @PostConstruct
    @Override
    public void init() {
        super.init();
    }

    @Override
    public EbayApiSearchResult searchApiCall(String query, String categoryIds) {
        System.out.println("Searching API with query: " + query);
        String request = configProperties.getEbayApiTemplate() + query;
        if (!categoryIds.equals("")) {
            request = request + "&category_ids=" + categoryIds;
        }
        try {
            String resultString = getRequestResultAsString(request);
            return mapper.readValue(resultString, EbayApiSearchResult.class);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public EbayApiSearchResult loadMore(String url) {
        String resultString;
        try {
            resultString = getRequestResultAsString(url);
            return mapper.readValue(resultString, EbayApiSearchResult.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    private String getRequestResultAsString(String request) throws IOException {
        URL url;
        url = new URL(request);
        HttpURLConnection con;
        con = (HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");
        con.setConnectTimeout(5000);
        con.setReadTimeout(5000);
        con.setRequestProperty("Authorization", configProperties.getApiToken());
        BufferedReader in = new BufferedReader(
                new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuilder content = new StringBuilder();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        con.disconnect();
        return content.toString();
    }

}
