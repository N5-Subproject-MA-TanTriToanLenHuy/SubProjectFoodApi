package com.example.subprojectfoodapi.Controller;

import com.example.subprojectfoodapi.Entity.Customer;
import com.example.subprojectfoodapi.Entity.Food;
import com.example.subprojectfoodapi.Entity.Order;
import com.example.subprojectfoodapi.Entity.Type;
import com.example.subprojectfoodapi.Repository.CustomerRepository;
import com.example.subprojectfoodapi.Repository.FoodRepository;
import com.example.subprojectfoodapi.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author MPHuy on 19/11/2021
 */
@RestController
@RequestMapping("/apiFood")
public class Controller {
    @Autowired
    private FoodRepository foodRepository;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @PostMapping("/order/saveOrder/{customerId}/{foodId}")
    public String saveOrder(@RequestBody Order order,@PathVariable int customerId,@PathVariable int foodId){
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
    @PostMapping("/order/saveOrder")
    public String saveFood(@RequestBody Food food){
        foodRepository.save(food);
        return "save success: "+ LocalDateTime.now();
    }
    @GetMapping("/food/{id}")
    public Food getFood(@PathVariable int id){
        return foodRepository.findById(id).get();
    }
    @GetMapping("/food/")
    public List<Food> getAllFood(){
        return foodRepository.findAll();
    }
    @GetMapping("/order/{id}")
    public Order getOrder(@PathVariable int id){
        return orderRepository.findById(id).get();
    }
    @GetMapping("/order/all/{customerId}")
    public List<Order> getAllOrder(@PathVariable int customerId){
        return orderRepository.findAllByCustomerId(customerId);
    }
    @GetMapping("/customer/{id}")
    public Customer getCustomer(@PathVariable int id){
        return customerRepository.findById(id).get();
    }
}
