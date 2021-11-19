package com.example.subprojectfoodapi.Repository;

import com.example.subprojectfoodapi.Entity.Food;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author MPHuy on 19/11/2021
 */
public interface FoodRepository extends JpaRepository<Food,Integer> {
}
