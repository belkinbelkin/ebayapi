package com.belkbelk.services;

import com.belkbelk.datastructures.EbayApiSearchResult;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class EbayApiDataSourceTest {

    @Test
    void loadMore() throws Exception{
        EbayApiSearchResult result = new EbayApiSearchResult();
        result.setNext("next");

        ConfigProperties properties = mock(ConfigProperties.class);
        when(properties.getApiToken()).thenReturn("test-api-token");
        when(properties.getEbayApiTemplate()).thenReturn("test-template");

        ObjectMapper mapper = mock(ObjectMapper.class);
        when(mapper.readValue("test-req-res", EbayApiSearchResult.class)).thenReturn(result);

        EbayApiDataSource source = mock(EbayApiDataSource.class);
        when(source.getMapper()).thenReturn(mapper);
        when(source.getRequestResultAsString("test-url")).thenReturn("test-req-res");

        when(source.loadMore("test-url")).thenCallRealMethod();

        EbayApiSearchResult ebayApiSearchResult = source.loadMore("test-url");
        assertEquals(ebayApiSearchResult.getNext(), result.getNext());

    }
}