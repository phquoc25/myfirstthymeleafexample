package com.qph.myfirstthymeleaf.business.services;

import com.qph.myfirstthymeleaf.business.entities.Customer;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by quoc on 09/01/2017.
 */
@RunWith(JUnit4.class)
public class CustomerServiceTest {
    private CustomerService customerService = new CustomerService();

    @Test
    public void findAll() throws Exception {
        List<Customer> customers = customerService.findAll();
        Assert.assertNotNull(customers);
        Assert.assertEquals(6, customers.size());
    }

    @Test
    public void findById() throws Exception {
        String expectedName = "George Garlic";
        Customer customer = customerService.findById(6);
        Assert.assertNotNull(customer);
        Assert.assertEquals(expectedName, customer.getName());
    }

}