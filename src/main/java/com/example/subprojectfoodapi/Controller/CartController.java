package com.example.subprojectfoodapi.Controller;


import com.example.subprojectfoodapi.Entity.Cart;
import com.example.subprojectfoodapi.Repository.CartRepository;
import com.example.subprojectfoodapi.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/cart")
public class CartController {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private CartService cartService;

    // get all cart
    @GetMapping("/carts")
    public List<Cart> findAllCart(){
        return cartRepository.findAll();
    }

    // save cart
    @PostMapping
    public Cart saveCart(@RequestBody Cart cart){

        if(cartService.findByName(cart.getName())){
            Cart c = cartRepository.findByName(cart.getName());
            c.setQuantity(c.getQuantity() + cart.getQuantity());
            c.setPrice(c.getPrice() + cart.getPrice());
            return cartRepository.save(c);
        }else{
            return cartRepository.save(cart);
        }
    }

    // delete cart
    @DeleteMapping ("/{id}")
    public void deleteCart(@PathVariable int id){
        cartRepository.deleteById(id);
    }

}
