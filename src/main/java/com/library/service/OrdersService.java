package com.library.service;

import com.library.domain.Book;
import com.library.domain.Orders;
import com.library.domain.User;
import com.library.repository.OrdersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrdersService {
    @Autowired
    private OrdersRepo ordersRepo;

    public Iterable<Orders> ordersFindAll(){
        return  ordersRepo.findAll();
    }

    public void delOrders(Orders orders){
        ordersRepo.delete(orders);
    }

    public void saveOrders(Orders orders){
        ordersRepo.save(orders);
    }

    public void takeOrders(Book book, User user){
        Orders orders = new Orders();
        orders.setBook(book);
        orders.setUser(user);
        saveOrders(orders);
    }


}
