package com.example.subprojectfoodapi.Repository;

import com.example.subprojectfoodapi.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart, Integer> {

}
