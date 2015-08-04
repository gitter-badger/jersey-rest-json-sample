
package com.ebay.tracking.skunkworks.searchapi.service;

import com.ebay.tracking.skunkworks.searchapi.entity.EntityOne;

import java.util.Collection;

public interface TestService {

    Collection<EntityOne> getAll();

    EntityOne getById(String id);

    EntityOne save(EntityOne entityOne);

    EntityOne deleteById(String id);

}
