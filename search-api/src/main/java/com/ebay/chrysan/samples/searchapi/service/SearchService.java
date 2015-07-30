
package com.ebay.chrysan.samples.searchapi.service;

import com.ebay.chrysan.samples.searchapi.entity.EntityOne;

import java.util.Collection;

public interface SearchService {

    Collection<EntityOne> getAll();

    EntityOne getById(String id);

    EntityOne save(EntityOne entityOne);

    EntityOne deleteById(String id);

}
