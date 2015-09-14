package org.foodie.server.controller;

import org.apache.log4j.Logger;
import org.foodie.server.dao.UserDao;
import org.foodie.server.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;



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
  private UserDao userDao;

  @Autowired
  Gson gson;
  
//  Logger.getLogger(UserController.class.getName());
  private static Logger log = Logger.getLogger(UserController.class.getName());
  
  /**
   * /create  --> Create a new user and save it in the database.
   * 
   * @param email User's email
   * @param name User's name
   * @return A string describing if the user is successfully created or not.
   */

  @RequestMapping("/register")
  @ResponseBody
  public String create(@RequestParam("user")User newUser) {  		  		
    try {
      userDao.save(newUser);
    }
    catch (Exception ex) {
      return "Error creating the user: " + ex.toString();
    }
    return "User succesfully created! (id = " + newUser.getId() + ")";
  }
  
  /**
   * /delete  --> Delete the user having the passed id.
   * 
   * @param id The id of the user to delete
   * @return A string describing if the user is succesfully deleted or not.
   */
  @RequestMapping("/delete")
  @ResponseBody
  public String delete(@RequestParam("id")long id) {
    try {
    	
      User user = new User(id);
      userDao.delete(user);
    }
    catch (Exception ex) {
      return "Error deleting the user:" + ex.toString();
    }
    return "User succesfully deleted!";
  }
  
  /**
   * /get-by-email  --> Return the id for the user having the passed email.
   * 
   * @param email The email to search in the database.
   * @return The user id or a message error if the user is not found.
   */

  @RequestMapping(value = "/get-by-email/{email}", method=RequestMethod.GET)
  public String getByEmail(@PathVariable String email) {
	  log.info(email);

    try {
      User user = userDao.findOneByEmail(email);
      return gson.toJson(user);
      
  	//convert the json string back to object
    // DataObject obj = gson.fromJson(br, DataObject.class);
  	// convert java object to JSON format,
  	// and returned as JSON formatted string

    }
    catch (Exception ex) {
      log.error(ex);
      return null;
    }
  }
  
  
  
  
  
  /**
   * /update  --> Update the email and the name for the user in the database 
   * having the passed id.
   * 
   * @param id The id for the user to update.
   * @param email The new email.
   * @param name The new name.
   * @return A string describing if the user is succesfully updated or not.
   */
  @RequestMapping("/update")
  @ResponseBody
  public String updateUser(@RequestParam("user")User updatedUser) {
    try {
    	userDao.save(updatedUser);
    }
    catch (Exception ex) {
      return "Error updating the user: " + ex.toString();
    }
    return "User succesfully updated!";
  }

} // class UserController