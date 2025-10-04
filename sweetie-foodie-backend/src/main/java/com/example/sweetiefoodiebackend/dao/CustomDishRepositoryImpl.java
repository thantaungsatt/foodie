package com.example.sweetiefoodiebackend.dao;

import com.example.sweetiefoodiebackend.entity.Dish;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.Root;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomDishRepositoryImpl implements CustomDishRepository{
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Dish> findFirst10Dishes() {
        return entityManager
                .createQuery("""
select dish from Dish dish
""",Dish.class)
                .setFirstResult(1)
                .setMaxResults(10)
                .getResultList();
    }
}
