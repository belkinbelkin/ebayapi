package com.belkbelk.abstractclasses;

import com.belkbelk.interfaces.IDataSource;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * REST API doesn't always work, so this class is an abstraction layer for another datasource.
 * Extending classes will have a Jackson mapper inherited from this class and will implement searchApiCall from IDataSource
 */
public abstract class AbstractDataSource implements IDataSource {

    public void init() {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        mapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        mapper.configure(DeserializationFeature.FAIL_ON_MISSING_CREATOR_PROPERTIES, false);
    }

    private ObjectMapper mapper = new ObjectMapper();

    public ObjectMapper getMapper(){
        return mapper;
    }

}
