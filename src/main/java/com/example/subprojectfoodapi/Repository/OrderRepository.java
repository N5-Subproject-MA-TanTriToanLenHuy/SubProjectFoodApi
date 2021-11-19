package com.example.subprojectfoodapi.Repository;

import com.example.subprojectfoodapi.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author MPHuy on 19/11/2021
 */
public interface OrderRepository extends JpaRepository<Order,Integer> {
    List<Order> findAllByCustomerId(int customerId);
}
