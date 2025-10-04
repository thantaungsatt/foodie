package com.example.sweetiefoodiebackend.service;

import com.example.sweetiefoodiebackend.dao.DishDao;
import com.example.sweetiefoodiebackend.dao.RestaurantDao;
import com.example.sweetiefoodiebackend.dto.DishInfoDto;
import com.example.sweetiefoodiebackend.entity.Dish;
import com.example.sweetiefoodiebackend.entity.Restaurant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SweetieFoodieService {
    @Autowired
    private DishDao dishDao;

    @Autowired
    private RestaurantDao restaurantDao;

    public List<Restaurant> findAllRestaurants(){
        return restaurantDao.findAll();
    }

    public List<Dish> fetch10Dishes(){
        return dishDao.findFirst10Dishes();
    }

    public List<DishInfoDto> fetchDishesByRestaurantId(int restaurantId){
        return dishDao.listAllDishInfoDto(restaurantId);
    }

    public Page<Dish> fetchDishesByPage(int pageNumber, int pageSize){
        Pageable pageable= PageRequest.of(pageNumber, pageSize);
        return dishDao.findAll(pageable);
    }



}
