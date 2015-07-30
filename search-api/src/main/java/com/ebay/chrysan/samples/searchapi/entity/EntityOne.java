
package com.ebay.chrysan.samples.searchapi.entity;

import java.util.Date;

public class EntityOne extends Entity {

    private String name;
    private Date created;
    private EntityTwo entityTwo;

    public EntityOne(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public EntityTwo getEntityTwo() {
        return entityTwo;
    }

    public void setEntityTwo(EntityTwo entityTwo) {
        this.entityTwo = entityTwo;
    }
}
