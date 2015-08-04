package com.ebay.tracking.skunkworks.searchapi.service.impl;

import com.ebay.tracking.skunk.work.consts.Consts;
import com.ebay.tracking.skunk.work.driver.FindingDriver;
import com.ebay.tracking.skunk.work.model.Commodity;
import com.ebay.tracking.skunkworks.searchapi.entity.SearchDimension;
import com.ebay.tracking.skunkworks.searchapi.entity.SearchRequest;
import com.ebay.tracking.skunkworks.searchapi.exception.BadParamException;
import com.ebay.tracking.skunkworks.searchapi.exception.InternalServiceErrorException;
import com.ebay.tracking.skunkworks.searchapi.service.SearchService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chrysan
 */
public class DefaultSearchService implements SearchService {
    private static final DefaultSearchService INSTANCE = new DefaultSearchService();
    public static SearchService getInstance() {
        return INSTANCE;
    }
    private DefaultSearchService() {}

    @Override
    public List<Commodity> search(SearchRequest request) {
        SearchDimension[] dimensions = request.getDimensions();
        if (dimensions == null) {
            throw new BadParamException();
        }
        Map<String, String> kvPair = new HashMap<>();
        try {
            kvPair.put("keywords", URLEncoder.encode(request.getKeywords(), "utf-8")); // convert
        } catch (UnsupportedEncodingException e) {
            throw new BadParamException();
        }
        for (SearchDimension dimension :dimensions) {
            switch (dimension.getName()) {
                case "price":
                    kvPair.put(Consts.PRICE_WEIGHT_KEY, String.valueOf(dimension.getValue()));
                    if (dimension.getOrder() != null) {
                        kvPair.put(Consts.PRICE_ORDER_KEY, dimension.getOrder().equals("desc") ? "down" : "up");
                    }
                    break;
                case "feedback":
                    kvPair.put(Consts.FEEDBACK_WEIGHT_KEY, "" + dimension.getValue());
                    break;
                case "time":
                    kvPair.put(Consts.TIME_WEIGHT_KEY, "" + dimension.getValue());
                    break;
            }
        }
        List<Commodity> commodities;
        try {
            commodities = FindingDriver.run(kvPair);
        } catch (Exception e) {
            e.printStackTrace();
            throw new InternalServiceErrorException();
        }
        return commodities;
    }
}
