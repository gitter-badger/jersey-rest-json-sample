package com.ebay.tracking.skunkworks.searchapi.controller;

import com.ebay.tracking.skunkworks.searchapi.entity.EntityOne;
import com.ebay.tracking.skunkworks.searchapi.exception.UnknownResourceException;
import com.ebay.tracking.skunkworks.searchapi.resource.CollectionResource;
import com.ebay.tracking.skunkworks.searchapi.resource.Link;
import com.ebay.tracking.skunkworks.searchapi.resource.entity.EntityOneResource;
import com.ebay.tracking.skunkworks.searchapi.service.TestService;
import com.ebay.tracking.skunkworks.searchapi.service.impl.DefaultTestService;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;

@Path(Link.PATH_SEPARATOR + "entityOne")
public class TestController extends BaseController {

    private TestService testService = DefaultTestService.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @SuppressWarnings("unchecked")
    public CollectionResource list(@Context UriInfo info,
                                   @DefaultValue("false") @QueryParam("expand") boolean expand) {
        Collection<EntityOne> entityOnes = testService.getAll();
        if (entityOnes == null || entityOnes.size() == 0) {
            return new CollectionResource(info, Link.entityUrlMapper.get(EntityOne.class), Collections.emptyList());
        }
        Collection items = new ArrayList(entityOnes.size());
        for( EntityOne entityOne : entityOnes) {
            if (expand) {
                items.add(new EntityOneResource(info, entityOne));
            } else {
                items.add(new Link(info, entityOne));
            }
        }
        return new CollectionResource(info, Link.entityUrlMapper.get(EntityOne.class), items);
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Context UriInfo info, EntityOne entityOne) {
        entityOne = testService.save(entityOne);
        EntityOneResource resource = new EntityOneResource(info, entityOne);
        return created(resource);
    }

    @Path("/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public EntityOneResource get(@Context UriInfo info, @PathParam("id") String id) {
        EntityOne entityOne = testService.getById(id);
        if (entityOne == null) {
            throw new UnknownResourceException();
        }
        return new EntityOneResource(info, entityOne);
    }

    @Path("/{id}")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(@Context UriInfo info, @PathParam("id") String id, Map map) {
        EntityOne existing = testService.getById(id);
        if (existing == null) {
            throw new UnknownResourceException();
        }
        //typically done via a framework call to automate this for any type of entity:
        if (map.containsKey("name")) {
            existing.setName(String.valueOf(map.get("name")));
        }
        existing = testService.save(existing);
        return Response.ok(new EntityOneResource(info, existing), MediaType.APPLICATION_JSON).build();
    }

    @Path("/{id}")
    @DELETE
    public void delete(@PathParam("id") String id) {
        EntityOne entityOne = testService.deleteById(id);
        if (entityOne == null) {
            throw new UnknownResourceException();
        }
    }
}
