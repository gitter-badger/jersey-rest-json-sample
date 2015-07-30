
package com.ebay.chrysan.samples.searchapi.resource.entity;

import com.ebay.chrysan.samples.searchapi.entity.EntityOne;
import com.ebay.chrysan.samples.searchapi.resource.Link;

import javax.ws.rs.core.UriInfo;

@SuppressWarnings("unchecked")
public class EntityOneResource extends Link {

    public EntityOneResource(UriInfo info, EntityOne entityOne) {
        super(info, entityOne);
        put("name", entityOne.getName());
        put("created", entityOne.getCreated());
        put("entityTwo", new Link(getFullyQualifiedContextPath(info), entityOne.getEntityTwo()));
    }
}
