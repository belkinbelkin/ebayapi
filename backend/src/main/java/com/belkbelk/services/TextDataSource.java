package com.belkbelk.services;

import com.belkbelk.abstractclasses.AbstractDataSource;
import com.belkbelk.datastructures.EbayApiSearchResult;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Service("textService")
public class TextDataSource extends AbstractDataSource {

    @PostConstruct
    @Override
    public void init() {
        super.init();
        InputStream stream = this.getClass().getResourceAsStream("/example.json");
        try {
            result = mapper.readValue(stream, EbayApiSearchResult.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Text service initialized");
    }

    EbayApiSearchResult result;

    @Override
    public EbayApiSearchResult searchApiCall(String query, String categoryIds) {
        return result;
    }

    @Override
    public EbayApiSearchResult loadMore(String url) {
        return null;
    }
}
