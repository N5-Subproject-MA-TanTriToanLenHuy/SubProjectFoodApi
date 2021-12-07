package com.example.subprojectfoodapi.Controller;


import com.example.subprojectfoodapi.Entity.Cart;
import com.example.subprojectfoodapi.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    // get all cart
    @GetMapping("/carts")
    public List<Cart> findAllCart(){
        return cartRepository.findAll();
    }

    // save cart
    @PostMapping
    public String saveCart(@RequestBody Cart cart){
        cartRepository.save(cart);
        return "save success" + LocalDateTime.now();
    }

    // delete cart
    @DeleteMapping ("/{id}")
    public void deleteCart(@PathVariable int cartId){
        cartRepository.deleteById(cartId);
    }

}
