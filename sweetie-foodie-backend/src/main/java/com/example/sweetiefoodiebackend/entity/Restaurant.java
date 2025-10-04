package com.example.sweetiefoodiebackend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Restaurant extends IdClass{
    private String address;
    @Column(name = "close_time")
    private LocalTime closeTime;
    private String email;
    @Column(name = "image_url")
    private String imageUrl;
    private String name;
    @Column(name = "open_time")
    private LocalTime openTime;
    private String phone;
    @JoinColumn(name = "category_id")
    @ManyToOne
    private Category category;
    @OneToMany(mappedBy = "restaurant")
    private List<Dish> dishes=
            new ArrayList<>();
}
