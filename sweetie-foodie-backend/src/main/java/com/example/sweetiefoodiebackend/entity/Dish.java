package com.example.sweetiefoodiebackend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
public class Dish  extends IdClass{
    private String image;
    private double price;
    private String slogan;
    private String title;
    @JoinColumn(name="restaurant_id")
    @ManyToOne
    private Restaurant restaurant;

    @Override
    public String toString() {
        return "Dish{" +
                "image='" + image + '\'' +
                ", price=" + price +
                ", slogan='" + slogan + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getSlogan() {
        return slogan;
    }

    public void setSlogan(String slogan) {
        this.slogan = slogan;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public void setRestaurant(Restaurant restaurant) {
        this.restaurant = restaurant;
    }
}
