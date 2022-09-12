package com.airhacks.controller;

import com.airhacks.model.Food;
import com.airhacks.service.FoodService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Optional;

@Path("Food")
public class FoodController {
    @Inject
    private FoodService foodService;

    @GET
    @Consumes(MediaType.APPLICATION_JSON)
    public Response getAllFoods() {
        return Response
                .ok(foodService.getAllFoods(), MediaType.APPLICATION_JSON)
                .build();
    }

    @GET
    @Path("{id}")
    public Response getFoodById(@PathParam("id") Integer id ){
        if( foodService.getFoodById(id).isPresent() ){
            return Response
                    .ok(foodService.getFoodById(id).get(), MediaType.APPLICATION_JSON )
                    .build();
        }
        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response saveFood(Food food){
        Optional<Food> newFood = foodService.addNewFood(food);
        if( newFood.isPresent() ) {
            return Response.ok( newFood, MediaType.APPLICATION_JSON ).build();
        }
        return Response.status( Response.Status.BAD_REQUEST).build();
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteFoodById( @PathParam("id") Integer id ){
        if( foodService.removeFoodById(id) ){
            return Response.status( Response.Status.ACCEPTED ).build();
        }
        return Response.status( Response.Status.NOT_FOUND ).build();
    }

    @PUT
    @Path("{id}")
    public Response updateFoodById( @PathParam("id") Integer id, Food food ){
        Optional<Food> newFood = foodService.updateFoodById(id, food);
        if(newFood.isPresent() ){
            return Response.status( Response.Status.ACCEPTED ).build();
        }
        return Response.status( Response.Status.NOT_FOUND ).build();
    }

}
