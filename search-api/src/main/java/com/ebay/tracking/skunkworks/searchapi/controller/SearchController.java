package com.ebay.tracking.skunkworks.searchapi.controller;

import com.ebay.tracking.skunk.work.model.Commodity;
import com.ebay.tracking.skunkworks.searchapi.entity.SearchRequest;
import com.ebay.tracking.skunkworks.searchapi.exception.UnknownResourceException;
import com.ebay.tracking.skunkworks.searchapi.resource.Link;
import com.ebay.tracking.skunkworks.searchapi.service.SearchService;
import com.ebay.tracking.skunkworks.searchapi.service.impl.DefaultSearchService;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

/**
 * @author chrysan
 */
@Path(Link.PATH_SEPARATOR + "search")
public class SearchController {
    private SearchService searchService = DefaultSearchService.getInstance();

    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response search(@Context UriInfo info, SearchRequest request) {
        if (request == null) {
            throw new UnknownResourceException();
        }
        List<Commodity> commodities = searchService.search(request);
//        List<Commodity> commodities = new ArrayList<>();
//        Commodity commodity = new Commodity();
//        commodity.setTitle("commodity");
//        commodities.add(commodity);
        return Response.ok(commodities, MediaType.APPLICATION_JSON).build();

    }
}
