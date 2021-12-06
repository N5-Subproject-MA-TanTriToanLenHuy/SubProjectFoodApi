package com.example.subprojectfoodapi.Repository;

import com.example.subprojectfoodapi.Entity.Food;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author MPHuy on 19/11/2021
 */

@Repository
public interface FoodRepository extends JpaRepository<Food,Integer> {

    @Query("SELECT f FROM Food f WHERE f.price <= 10")
    List<Food> findAllByPrice(Pageable pageable);

}
