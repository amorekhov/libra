package com.library.service;

import com.library.domain.Book;
import com.library.domain.Orders;
import com.library.domain.User;
import com.library.repository.OrdersRepo;
import org.aspectj.weaver.ast.Or;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
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
        ordersService.ordersFindAll();
        Mockito.verify(ordersRepo, Mockito.times(1)).findAll();
    }

    @Test
    public void delOrders() {
        Orders orders = new Orders();
        ordersService.delOrders(orders);
        Mockito.verify(ordersRepo,Mockito.times(1)).delete(orders);
    }

    @Test
    public void saveOrders() {
        Orders orders = new Orders();
        ordersService.saveOrders(orders);
    }

    @Test
    public void takeOrders() {
        Book book = new Book();
        User user = new User();
        ordersService.takeOrders(book,user);
        Mockito.verify(ordersRepo, Mockito.times(1)).save(ArgumentMatchers.any(Orders.class));


    }
}