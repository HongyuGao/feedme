package org.foodie.server.controller;

import org.foodie.server.entity.User;
import org.foodie.server.service.UserService;
import org.foodie.server.service.UserServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


/**
 * A class to test interactions with the MySQL database using the UserDao class.
 *
 * 
 * @author Danyang Li
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
  @Autowired
  private UserService userService;

  @RequestMapping("/register")
  @ResponseBody
  public String create(@RequestParam("user")User newUser) {  		  		
    try {
      userService.create(newUser);
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created! (id = " + newUser.getId() + ")";
  }
  
  @RequestMapping("/delete")
  @ResponseBody
  public String delete(/*@RequestParam("id")long id*/) {
    try {
    	long id = 6;
      User user = new User(id);
      userService.remove(user);
    }
    catch (Exception ex) {
      return "Error deleting the user:" + ex.toString();
    }
    return "User succesfully deleted!";
  }
  
  @RequestMapping("/get-by-email")
  @ResponseBody
  public String getByEmail(@RequestParam("email")String email) {
    String userId;
    try {
      User user = userService.query(email);
      userId = String.valueOf(user.getId());
    }
    catch (Exception ex) {
      return "User not found";
    }
    return "The user id is: " + userId;
  }
  
  @RequestMapping("/update")
  @ResponseBody
  public String updateUser(@RequestParam("user")User updatedUser) {
    try {
    	userService.update(updatedUser);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User succesfully updated!";
  }

}