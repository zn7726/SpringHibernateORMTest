package com.springtest.ormtest.entities;

import org.hibernate.annotations.Parent;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Embeddable
public class GroupedCustomer {
    @Column(name="isGroupLeader", nullable=false)
    private boolean groupLeader = false;

    @Column(name="dateAdded", nullable=false)
    private Date addedDate = new Date();

    @Parent
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "groupId", nullable = false, updatable = false)
    private CustomerGroup group;

    public GroupedCustomer(boolean groupLeader, Customer customer, CustomerGroup group) {
        this.groupLeader = groupLeader;
        this.customer = customer;
        this.group = group;
    }

    public GroupedCustomer() {
    }

    public boolean isGroupLeader() {
        return groupLeader;
    }

    public void setGroupLeader(boolean groupLeader) {
        this.groupLeader = groupLeader;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public CustomerGroup getGroup() {
        return group;
    }

    public void setGroup(CustomerGroup group) {
        this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GroupedCustomer that = (GroupedCustomer) o;

        if (groupLeader != that.groupLeader) return false;
        if (addedDate != null ? !addedDate.equals(that.addedDate) : that.addedDate != null) return false;
        if (customer != null ? !customer.equals(that.customer) : that.customer != null) return false;
        return group != null ? group.equals(that.group) : that.group == null;
    }

    @Override
    public int hashCode() {
        int result = (groupLeader ? 1 : 0);
        result = 31 * result + (addedDate != null ? addedDate.hashCode() : 0);
        result = 31 * result + (customer != null ? customer.hashCode() : 0);
        result = 31 * result + (group != null ? group.hashCode() : 0);
        return result;
    }
}
