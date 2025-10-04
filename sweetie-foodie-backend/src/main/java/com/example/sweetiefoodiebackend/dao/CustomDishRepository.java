package com.example.sweetiefoodiebackend.dao;

import com.example.sweetiefoodiebackend.entity.Dish;

import java.util.List;

public interface CustomDishRepository {
    List<Dish> findFirst10Dishes();
}
