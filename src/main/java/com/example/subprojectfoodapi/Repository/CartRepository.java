package com.example.subprojectfoodapi.Repository;

import com.example.subprojectfoodapi.Entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {

    @Query("SELECT c FROM Cart c where c.name = :name")
    Cart findByName(String name);

}
