package org.foodie.server.controller;

import java.util.List;

import org.foodie.server.entity.Restaurant;
import org.foodie.server.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * 
 * @author Danyang Li
 *
 */
@RestController
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@RequestMapping("/newrestaurant")
	@ResponseBody
	public String create(){
		//test data
		Restaurant newRestaurant = new Restaurant();
		newRestaurant.setName("Name1");
		//
		try{
			restaurantService.create(newRestaurant);			
		}catch(Exception ex){
			return "exception";			
		}
		return "success!"+newRestaurant.getId();
	}
	
	@RequestMapping("/delete")
	@ResponseBody
	public String delete(){
		//test data
		long id = 1;
		Restaurant restaurant = new Restaurant(id);
		//
		try{
			restaurantService.remove(restaurant);
		}catch(Exception e){
			return "error";
		}		
		return "success!";		
	}
	
	@RequestMapping("/update")
	@ResponseBody
	public String update(){
		//test data
		long id = 1;
		Restaurant restaurant = new Restaurant(id);
		restaurant.setName("newName");
		try{
			restaurantService.update(restaurant);
		}catch(Exception e){
			return "error";
		}
		return "success!";
	}
	
	@RequestMapping("/query")
	@ResponseBody
	public List<Restaurant> query(){
		return restaurantService.query();
	}
	
}