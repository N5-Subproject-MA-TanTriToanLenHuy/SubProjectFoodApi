package com.example.subprojectfoodapi.Controller;

import com.example.subprojectfoodapi.Entity.Customer;
import com.example.subprojectfoodapi.Entity.Food;
import com.example.subprojectfoodapi.Entity.Order;
import com.example.subprojectfoodapi.Repository.CustomerRepository;
import com.example.subprojectfoodapi.Repository.FoodRepository;
import com.example.subprojectfoodapi.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MPHuy on 26/11/2021
 */
@RestController
@RequestMapping("/api/order")
public class OrderController {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;

    @PostMapping("/customer/{customerId}/food/{foodId}")
    public String saveOrder(@RequestBody Order order, @PathVariable int customerId, @PathVariable int foodId){
        Customer customer = customerRepository.findById(customerId).get();
        Food food = foodRepository.findById(foodId).get();
        if(customer != null){
            return "not found customer id: " + customerId;
        }
        order.setCustomer(customer);
        order.setFood(food);
        orderRepository.save(order);
        return "save success: "+ LocalDateTime.now();
    }
    // get order
    @GetMapping("/{id}")
    public Order getOrder(@PathVariable int id){
        return orderRepository.findById(id).get();
    }
    // get All Order of customer
    @GetMapping("/customer/{customerId}")
    public List<Order> getAllOrderOfCustomer(@PathVariable int customerId){
        return orderRepository.findAllByCustomerId(customerId);
    }
}
