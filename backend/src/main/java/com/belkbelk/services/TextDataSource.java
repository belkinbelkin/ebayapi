package com.belkbelk.services;

import com.belkbelk.abstractclasses.AbstractDataSource;
import com.belkbelk.datastructures.EbayApiSearchResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;

@Service("textService")
public class TextDataSource extends AbstractDataSource {

    Logger logger = LoggerFactory.getLogger(TextDataSource.class);

    @PostConstruct
    @Override
    public void init() {
        super.init();
        InputStream stream = this.getClass().getResourceAsStream("/example.json");
        try {
            result = getMapper().readValue(stream, EbayApiSearchResult.class);
        } catch (IOException e) {
            logger.error(e.getMessage(), e);
        }
        logger.info("Text service initialized");
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
