package com.belkbelk.interfaces;

import com.belkbelk.datastructures.EbayApiSearchResult;

/**
 * Search service interface class
 */
public interface IDataSource {

    EbayApiSearchResult searchApiCall(String query, String categoryIds);
    EbayApiSearchResult loadMore(String url);

}
