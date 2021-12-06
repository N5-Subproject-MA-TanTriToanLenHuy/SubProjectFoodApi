package com.example.subprojectfoodapi.Controller;

import com.example.subprojectfoodapi.Entity.Food;
import com.example.subprojectfoodapi.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MPHuy on 26/11/2021
 */
@RestController
@RequestMapping("/api/food")
public class FoodController {

    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @Autowired
    private FoodRepository foodRepository;

    // get food by id
    @GetMapping("/{id}")
    public Food getFood(@PathVariable int id){
        return foodRepository.findById(id).get();
    }

    // get all food
    @GetMapping("/trending")
    public List<Food> trendingFood(){
        return foodRepository.findAll(PageRequest.of(foodRepository.findAll().size() - 10, foodRepository.findAll().size())).getContent();
    }

    @GetMapping("/favorites")
    public List<Food> favoritesFood(){
        return foodRepository.findAllByPrice(
                PageRequest.of(foodRepository.findAllByPrice(Pageable.unpaged()).size() - 10,
                        foodRepository.findAllByPrice(Pageable.unpaged()).size()));
    }

    // save food
    @PostMapping
    public String saveFood(@RequestBody Food food){
        foodRepository.save(food);
        return "save success: "+ LocalDateTime.now();
    }

    // delete food
    @DeleteMapping("/{id}")
    public void deleteFood(@PathVariable int id){
        foodRepository.deleteById(id);
    }

    // update food
    @PutMapping("{id}")
    public Food updateFood(@RequestBody Food food, @PathVariable int id){
        food.setId(id);
        return foodRepository.save(food);
    }
}
