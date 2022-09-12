package com.airhacks.service;

import com.airhacks.model.Food;

import java.util.List;
import java.util.Optional;

public interface FoodService {

    List<Food> getAllFoods();

    Optional<Food> getFoodById(final int id);

    Optional<Food> addNewFood(final Food food);

    boolean removeFoodById(final int id);

    Optional<Food> updateFoodById(final int id, final Food food);

}
