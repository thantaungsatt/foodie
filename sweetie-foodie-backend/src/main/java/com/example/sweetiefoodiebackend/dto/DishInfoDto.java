package com.example.sweetiefoodiebackend.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;




public class DishInfoDto {
    private String image;
    private double price;
    private String slogan;
    private String title;
    private int restaurantId;

    public DishInfoDto() {}

    public DishInfoDto(String image, double price, String slogan, String title, int restaurantId) {
        this.image = image;
        this.price = price;
        this.slogan = slogan;
        this.title = title;
        this.restaurantId = restaurantId;
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

    public int getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(int restaurantId) {
        this.restaurantId = restaurantId;
    }

    @Override
    public String toString() {
        return "DishInfoDto{" +
                "image='" + image + '\'' +
                ", price=" + price +
                ", slogan='" + slogan + '\'' +
                ", title='" + title + '\'' +
                ", restaurantId=" + restaurantId +
                '}';
    }
}
