package com.example.sweetiefoodiebackend.controller;

import com.example.sweetiefoodiebackend.dao.RestaurantDao;
import com.example.sweetiefoodiebackend.dto.DishInfoDto;
import com.example.sweetiefoodiebackend.entity.Dish;
import com.example.sweetiefoodiebackend.entity.Restaurant;
import com.example.sweetiefoodiebackend.service.SweetieFoodieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
@RequestMapping("/api/sweetie-foodie")
public class SweetieFoodieController {
    @Autowired
    private SweetieFoodieService sweetieFoodieService;

    public record RestaurantDto(int id,String address, LocalTime closeTime, String email, String imageUrl, String name, LocalTime openTime, String phone){}

    public record DishDto(String title,String image,double price,String sologan){}

    public RestaurantDto toRestaurantDto(Restaurant restaurant){
        return new RestaurantDto(restaurant.getId(), restaurant.getAddress(),restaurant.getCloseTime(), restaurant.getEmail(),restaurant.getImageUrl(),restaurant.getName(),restaurant.getOpenTime(),restaurant.getPhone());
    }

    @GetMapping("/list-restaurant")
    public List<RestaurantDto> restaurantList(){
        return sweetieFoodieService.findAllRestaurants()
                .stream()
                .map(this::toRestaurantDto)
                .toList();
    }

    public DishDto toDishDto(Dish dish){
        return new DishDto(dish.getTitle(),
                dish.getImage(),
                dish.getPrice(),
                dish.getSlogan());
    }
    // localhost:8080/api/sweetie-foodie/dishes/pagination?page=1&size=5
    @GetMapping("/dishes/pagination")
    public Page<Dish> getDishes(@RequestParam("page")int page,
                                @RequestParam("size")int size){
        return sweetieFoodieService.fetchDishesByPage(page,size);
    }
    @GetMapping("/10-dishes")
    public List<DishDto> fetch10Dishes(){
        return sweetieFoodieService
                .fetch10Dishes()
                .stream()
                .map(this::toDishDto)
                .toList();
    }
    @GetMapping("/dishes/restaurant/{id}")
    public List<DishInfoDto>
        fetchDishesInfo(@PathVariable("id")int restaurantId){
        return sweetieFoodieService.fetchDishesByRestaurantId(restaurantId);
    }
}
