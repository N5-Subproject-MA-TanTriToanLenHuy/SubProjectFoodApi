package com.example.subprojectfoodapi.service;

import com.example.subprojectfoodapi.Repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public boolean findByName(String name){

        if(cartRepository.findByName(name) != null){
            return true;
        }else {
            return false;
        }

    }
}
