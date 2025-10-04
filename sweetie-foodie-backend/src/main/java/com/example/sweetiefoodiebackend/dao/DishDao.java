package com.example.sweetiefoodiebackend.dao;

import com.example.sweetiefoodiebackend.dto.DishInfoDto;
import com.example.sweetiefoodiebackend.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface DishDao extends JpaRepository<Dish,Integer>
        ,CustomDishRepository {
    @Query("""
select new com.example.sweetiefoodiebackend.dto.DishInfoDto(
dish.image,
dish.price,
dish.slogan,
dish.title,
re.id
)
from Dish dish join dish.restaurant re where re.id = ?1
""")
    List<DishInfoDto> listAllDishInfoDto(int restaurantId);

}
