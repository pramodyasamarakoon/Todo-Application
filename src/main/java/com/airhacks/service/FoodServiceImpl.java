package com.airhacks.service;

import com.airhacks.model.Food;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FoodServiceImpl implements FoodService {

    private List<Food> foodsDB = new ArrayList<>();

    @Override
    public List<Food> getAllFoods() {
        return foodsDB;
    }

    @Override
    public Optional<Food> getFoodById(int id) {
        for (Food f:foodsDB ) {
            if(f.getId() == id){
                return Optional.of(f);
            }
        }
        return Optional.empty();
    }

    @Override
    public Optional<Food> addNewFood(Food food) {
        for (Food f:foodsDB){
            if(f.getName() == food.getName()){
                return Optional.empty();
            }
        }
        foodsDB.add(food);
        return Optional.of(food);
    }

    @Override
    public boolean removeFoodById(int id) {
        for (Food f: foodsDB){
            if(f.getId() == id){
                foodsDB.remove(f);
                return true;
            }
        }
        return false;
    }

    @Override
    public Optional<Food> updateFoodById(int id, Food food) {
        for (Food f: foodsDB){
            if (f.getId() == id ){
                f.setName(food.getName());
                f.setPrice(food.getPrice());
                f.setMealType(food.getMealType());
                return Optional.of(f);
            }
        }
        return Optional.empty();
    }
}
