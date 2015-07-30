package com.ebay.chrysan.samples.searchapi.controller;

import com.ebay.chrysan.samples.searchapi.resource.Link;

import javax.ws.rs.core.Response;
import java.net.URI;

@SuppressWarnings("MismatchedQueryAndUpdateOfCollection")
public abstract class BaseController {

    protected Response created(Link resource) {
        String href = (String)resource.get("href");
        URI uri = URI.create(href);
        return Response.created(uri).entity(resource).build();
    }

}
