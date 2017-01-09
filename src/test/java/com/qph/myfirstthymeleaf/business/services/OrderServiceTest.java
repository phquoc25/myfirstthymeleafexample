package com.qph.myfirstthymeleaf.business.services;

import com.qph.myfirstthymeleaf.business.entities.Order;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.junit.Assert.*;

/**
 * Created by quoc on 09/01/2017.
 */
@RunWith(JUnit4.class)
public class OrderServiceTest {
    private OrderService orderService = new OrderService();

    @Test
    public void findAll() throws Exception {
        List<Order> orders = orderService.findAll();
        Assert.assertNotNull(orders);
        Assert.assertEquals(3, orders.size());
    }

    @Test
    public void findById() throws Exception {
        Order order1 = orderService.findById(1);
        Assert.assertNotNull(order1);
        Assert.assertEquals(Integer.valueOf(4), order1.getCustomer().getId());
        Assert.assertEquals(3, order1.getOrderLines().size());
    }

    @Test
    public void findByCustomerId() throws Exception {
        List<Order> orders = orderService.findByCustomerId(4);
        Assert.assertEquals(2, orders.size());
        List<Integer> orderIds = orders.stream().map(Order::getId).collect(toList());
        Assert.assertTrue(orderIds.contains(1));
        Assert.assertTrue(orderIds.contains(3));
    }

}