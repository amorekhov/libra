package com.library.service;

import com.library.domain.Orders;
import com.library.repository.OrdersRepo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrdersServiceTest {
    @Autowired
    private OrdersService ordersService;

    @MockBean
    private OrdersRepo ordersRepo;

    @Test
    public void ordersFindAll() {
    }

    @Test
    public void delOrders() {
    }

    @Test
    public void saveOrders() {
    }

    @Test
    public void takeOrders() {
    }
}