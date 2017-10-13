package com.springtest.ormtest.entities;

import com.springtest.ormtest.repos.CustomerGroupRepository;
import com.springtest.ormtest.repos.CustomerRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CustomerTest {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerGroupRepository groupRepository;

    Customer customer1 = new Customer("Customer One");
    Customer customer2 = new Customer("Customer Two");
    Customer customer3 = new Customer("Customer Three");

    CustomerGroup group1 = new CustomerGroup("Group One");
    CustomerGroup group2 = new CustomerGroup("Group Two");
    CustomerGroup group3 = new CustomerGroup("Group Three");

    @Before
    public void setup() {
        customerRepository.save(customer1);
        customerRepository.save(customer2);
        customerRepository.save(customer3);

        groupRepository.save(group1);
        groupRepository.save(group2);
        groupRepository.save(group3);
    }

    @Transactional
    @Test
    public void shouldSaveCustomerAndGroup() {

        GroupedCustomer gc_c1_g1 = new GroupedCustomer(false, customer1, group1);
        GroupedCustomer gc_c1_g2 = new GroupedCustomer(false, customer1, group2);
        GroupedCustomer gc_c1_g3 = new GroupedCustomer(true, customer1, group3);

        GroupedCustomer gc_c2_g1 = new GroupedCustomer(true, customer2, group1);
        GroupedCustomer gc_c2_g2 = new GroupedCustomer(false, customer2, group2);
        GroupedCustomer gc_c2_g3 = new GroupedCustomer(false, customer2, group3);

        customer1.addGroup(gc_c1_g1);
        customer1.addGroup(gc_c1_g2);
        customer1.addGroup(gc_c1_g3);

        customer2.addGroup(gc_c2_g1);
        customer2.addGroup(gc_c2_g2);
        customer2.addGroup(gc_c2_g3);

        customerRepository.save(customer1);
        customerRepository.save(customer2);

        Customer c1 = customerRepository.findOne(customer1.getId());

        assert(c1.getCustomerGroups().isEmpty() == false);
        assert(c1.getCustomerGroups().size() == 3);
        c1.getCustomerGroups().stream().forEach(
                g -> {
                    System.out.println(g.getGroup().getGroupName());
                }
        );
    }
}