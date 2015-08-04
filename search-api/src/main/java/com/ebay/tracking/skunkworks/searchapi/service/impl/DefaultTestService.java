package com.ebay.tracking.skunkworks.searchapi.service.impl;

import com.ebay.tracking.skunkworks.searchapi.entity.EntityOne;
import com.ebay.tracking.skunkworks.searchapi.entity.EntityTwo;
import com.ebay.tracking.skunkworks.searchapi.service.TestService;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;


public class DefaultTestService implements TestService {
    //ordinarily DependencyInjection would be used.  This simple example just uses a static singleton:
    private static final DefaultTestService INSTANCE = new DefaultTestService();

    EntityOne entityOne;
    private DefaultTestService() {
        entityOne = new EntityOne();
        entityOne.setId("1");
        entityOne.setName("a");
        entityOne.setCreated(new Date());
        EntityTwo two = new EntityTwo();
        two.setGivenName("b");
        two.setId("2");
        entityOne.setEntityTwo(two);
    }

    public static TestService getInstance() {
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
        return this.entityOne;
    }

    @Override
    public EntityOne deleteById(String id) {
        return entityOne;
    }
}
