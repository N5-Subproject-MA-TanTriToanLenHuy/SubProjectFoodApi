package com.example.subprojectfoodapi.Controller;

import com.example.subprojectfoodapi.Entity.Customer;
import com.example.subprojectfoodapi.Entity.Order;
import com.example.subprojectfoodapi.Repository.CustomerRepository;
import com.example.subprojectfoodapi.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author MPHuy on 26/11/2021
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    // get customer
    @GetMapping("/{id}")
    public Customer getCustomer(@PathVariable int id){
        return customerRepository.findById(id).get();
    }
}
