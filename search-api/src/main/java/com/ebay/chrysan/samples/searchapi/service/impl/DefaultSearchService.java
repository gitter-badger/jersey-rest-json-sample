package com.ebay.chrysan.samples.searchapi.service.impl;

import com.ebay.chrysan.samples.searchapi.entity.EntityOne;
import com.ebay.chrysan.samples.searchapi.entity.EntityTwo;
import com.ebay.chrysan.samples.searchapi.service.SearchService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


public class DefaultSearchService implements SearchService {
    //ordinarily DependencyInjection would be used.  This simple example just uses a static singleton:
    private static final DefaultSearchService INSTANCE = new DefaultSearchService();

    EntityOne entityOne;
    private DefaultSearchService() {
        entityOne = new EntityOne();
        entityOne.setId("1");
        entityOne.setName("a");
        entityOne.setCreated(new Date());
        EntityTwo two = new EntityTwo();
        two.setGivenName("b");
        two.setId("2");
        entityOne.setEntityTwo(two);
    }

    public static SearchService getInstance() {
        return INSTANCE;
    }

    @Override
    public Collection<EntityOne> getAll() {
        List<EntityOne> list = new ArrayList<>();
        list.add(entityOne);
        return list;
    }

    @Override
    public EntityOne getById(String id) {
        return entityOne;
    }

    @Override
    public EntityOne save(EntityOne entityOne) {
        return entityOne;
    }

    @Override
    public EntityOne deleteById(String id) {
        return entityOne;
    }
}
