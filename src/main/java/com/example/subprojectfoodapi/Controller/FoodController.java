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
    public List<Food> trendingFood(){
        Pageable pageable;
        int page = foodRepository.findAll().size() - 10;
        int size = foodRepository.findAll().size();

        if(page < 0 || size <= 0)
            pageable = Pageable.unpaged();
        else
            pageable = PageRequest.of(page, size);

        return foodRepository.findAll(pageable).getContent();
    }

    // get all food favourites
    @GetMapping("/favourites")
    public List<Food> favoritesFood(){
        Pageable pageable;
        Pageable pageable1;
        int page1 = 0;
        int size1 = 0;

        if(page1 < 0 || size1 <= 0)
            pageable1 = Pageable.unpaged();
        else
            pageable1 = PageRequest.of(page1, size1);

        int page = foodRepository.findAllByPrice(pageable1).size() - 10;
        int size = foodRepository.findAllByPrice(pageable1).size();

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
