package com.belkbelk.tests;

import com.belkbelk.Application;
import com.belkbelk.abstractclasses.AbstractDataSource;
import com.belkbelk.datastructures.EbayApiSearchResult;
import com.belkbelk.datastructures.EbayApiSearchResultEntry;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static com.belkbelk.tests.TestUtils.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class JsonParsingTest {

    Logger logger = LoggerFactory.getLogger(JsonParsingTest.class);

    @Autowired
    @Qualifier("textService")
    AbstractDataSource dataSource;

    @Test
    public void testResultObjectValidity() {

        logger.info("Checking if all necessary fields are present");

        EbayApiSearchResult result = dataSource.searchApiCall("shoes", "");
        Assert.assertNotNull(result.getItemSummaries());
        Assert.assertNotEquals(result.getItemSummaries().size(), 0);

        testString(result.getHref());
        Assert.assertTrue(urlIsValid(result.getHref()));

        testString(result.getNext());
        Assert.assertTrue(urlIsValid(result.getNext()));

        EbayApiSearchResultEntry entry = result.getItemSummaries().get(0);
        Assert.assertNotNull(entry.getImage());
        testString(entry.getImage().getImageUrl());
        Assert.assertTrue(urlIsValid(entry.getImage().getImageUrl()));

        logger.info("Parsed object is valid, all necessary fields are present");

    }

}
