package com.airhacks.model;

public class Food {
    private int id;
    private String name;
    private float price;
    private String mealType;

    public Food() {
    }

    public Food(int id, String name, float price, String mealType) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.mealType = mealType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getMealType() {
        return mealType;
    }

    public void setMealType(String mealType) {
        this.mealType = mealType;
    }
}
