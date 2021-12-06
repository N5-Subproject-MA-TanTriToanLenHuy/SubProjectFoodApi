package com.example.subprojectfoodapi.Controller;

import com.example.subprojectfoodapi.Entity.Food;
import com.example.subprojectfoodapi.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * @author MPHuy on 26/11/2021
 */
@RestController
@RequestMapping("/api/food")
public class FoodController {

//    private static final Path CURRENT_FOLDER = Paths.get(System.getProperty("user.dir"));

    @Autowired
    private FoodRepository foodRepository;

    // get food by id
    @GetMapping("/{id}")
    public Food getFood(@PathVariable int id){
        return foodRepository.findById(id).get();
    }

    @GetMapping
    public List<Food> allFoods(){
        return foodRepository.findAll();
    }

    // get all food trending
    @GetMapping("/trending")
    public List<Food> trendingFood(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "0") int size){

        Pageable pageable;
        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page, size);

        return foodRepository.findAll(pageable).getContent();
    }

    // get all food favourites
    @GetMapping("/favourites")
    public List<Food> favoritesFood(@RequestParam(defaultValue = "0") int page
            , @RequestParam(defaultValue = "0") int size){
        Pageable pageable;

        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page, size);

        return foodRepository.findAllByPrice(pageable);
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
