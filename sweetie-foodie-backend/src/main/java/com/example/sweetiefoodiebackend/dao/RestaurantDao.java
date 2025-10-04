package com.example.sweetiefoodiebackend.dao;

import com.example.sweetiefoodiebackend.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantDao extends JpaRepository<Restaurant,Integer> {
}
