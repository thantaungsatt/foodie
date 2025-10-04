package com.example.sweetiefoodiebackend;

import com.example.sweetiefoodiebackend.dao.DishDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SweetieFoodieBackendApplication {
    @Autowired
    private DishDao dishDao;
    @Bean
    public ApplicationRunner runner(){
        return r ->{
//            dishDao.listAllDishInfoDto(2)
//                    .forEach(System.out::println);
//            dishDao.findFirst10Dishes()
//                    .forEach(System.out::println);
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(SweetieFoodieBackendApplication.class, args);
    }

}
