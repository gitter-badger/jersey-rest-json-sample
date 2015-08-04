
package com.ebay.tracking.skunkworks.searchapi.resource.entity;

import com.ebay.tracking.skunkworks.searchapi.entity.EntityOne;
import com.ebay.tracking.skunkworks.searchapi.resource.Link;

import javax.ws.rs.core.UriInfo;

@SuppressWarnings("unchecked")
public class EntityOneResource extends Link {

    public EntityOneResource(UriInfo info, EntityOne entityOne) {
        super(info, entityOne);
        put("id", entityOne.getId());
        put("name", entityOne.getName());
        put("created", entityOne.getCreated());
        put("entityTwo", new Link(getFullyQualifiedContextPath(info), entityOne.getEntityTwo()));
    }
}
