package com.ebay.tracking.skunkworks.searchapi.service;

import com.ebay.tracking.skunk.work.model.Commodity;
import com.ebay.tracking.skunkworks.searchapi.entity.SearchRequest;

import java.util.List;

/**
 * @author chrysan
 */
public interface SearchService {
    public List<Commodity> search(SearchRequest request);
}
