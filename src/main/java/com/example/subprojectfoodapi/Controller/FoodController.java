package com.example.subprojectfoodapi.Controller;

import com.example.subprojectfoodapi.Entity.Food;
import com.example.subprojectfoodapi.Repository.FoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
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
    @GetMapping("/all")
    public List<Food> getAllFood(){
        return foodRepository.findAll();
    }

    // save food
    @PostMapping
    public String saveFood(@RequestParam String name,
                           @RequestParam double price,
                           @RequestParam String description,
                           @RequestParam MultipartFile image) throws IOException {

        Path imagePath = resolveImagePath(image);

        Food food = Food.builder()
                .name(name)
                .price(price)
                .description(description)
                .logo(imagePath.resolve(image.getOriginalFilename()).toString())
                .build();

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
    public Food updateFood(@PathVariable int id,
                           @RequestParam String name,
                           @RequestParam double price,
                           @RequestParam String description,
                           @RequestParam MultipartFile image) throws IOException {

        Path imagePath = resolveImagePath(image);

        Food food = Food.builder()
                .id(id)
                .name(name)
                .price(price)
                .description(description)
                .logo(imagePath.resolve(image.getOriginalFilename()).toString())
                .build();

        return foodRepository.save(food);
    }

    private Path resolveImagePath(MultipartFile image) throws IOException {
        Path staticPath = Paths.get("static");
        Path imagePath = Paths.get("images");
        if (!Files.exists(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath))) {
            Files.createDirectories(CURRENT_FOLDER.resolve(staticPath).resolve(imagePath));
        }
        Path file = CURRENT_FOLDER.resolve(staticPath)
                .resolve(imagePath).resolve(image.getOriginalFilename());
        try (OutputStream os = Files.newOutputStream(file)) {
            os.write(image.getBytes());
        }

        return imagePath;
    }
}
