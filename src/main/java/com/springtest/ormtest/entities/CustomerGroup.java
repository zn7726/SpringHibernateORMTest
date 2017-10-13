package com.springtest.ormtest.entities;

import javax.persistence.*;

@Entity
@Table(name="entity_group")
public class CustomerGroup {
    @Id
    @GeneratedValue
    private int id;

    private String groupName;

    public CustomerGroup(String groupName) {
        this.groupName = groupName;
    }

    public CustomerGroup() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }
}
