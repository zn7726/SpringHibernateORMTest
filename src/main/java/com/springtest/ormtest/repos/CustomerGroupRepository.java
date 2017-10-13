package com.springtest.ormtest.repos;

import com.springtest.ormtest.entities.CustomerGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerGroupRepository extends JpaRepository<CustomerGroup, Integer> {
}
