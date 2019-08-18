package com.library.repository;

import com.library.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrdersRepo extends JpaRepository <Orders,Long> {
}
