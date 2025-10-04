package com.example.sweetiefoodiebackend.dao;

import com.example.sweetiefoodiebackend.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryDao extends JpaRepository<Category,Integer> {
}
