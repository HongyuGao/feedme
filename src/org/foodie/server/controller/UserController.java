package org.foodie.server.controller;
import org.apache.log4j.Logger;
import org.foodie.server.entity.User;
import org.foodie.server.infor.ErrorCode;
import org.foodie.server.infor.Infor;
import org.foodie.server.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
/**
 * A class to test interactions with the MySQL database using the UserService class.
 * @author Danyang Li
 */
@RestController
@RequestMapping("/users")
public class UserController {
	
  @Autowired
  private UserService userService;
  
  private static Logger log = Logger.getLogger(UserController.class.getName());
  
  @RequestMapping("/checkEmail")
  @ResponseBody
  public Infor checkEmail(@RequestParam("email")String email){
	  Infor infor=new Infor();
	  try{
		  User user = userService.query(email);
		  if (user==null){
			  infor.setErrorInfo("Y");
			  infor.setStatusCode(ErrorCode.NONE);
			  return infor;
		  }else{
			  infor.setErrorInfo("N");
			  infor.setStatusCode(ErrorCode.NONE);
			  return infor;
		  }
	  }catch(Exception e){
		  infor.setErrorInfo("");
		  infor.setStatusCode(ErrorCode.PERSIST_ERROR);
		  return infor;
	  }
  }
  
  @RequestMapping(value="/register", method=RequestMethod.POST)
  @ResponseBody
  public String create(@RequestBody User newUser) {  		  		
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
  /**
   * /get-by-email  --> Return the id for the user having the passed email.
   * 
   * @param email The email to search in the database.
   * @return The user id or a message error if the user is not found.
   */

  @RequestMapping("getByEmail")
  @ResponseBody
  public User getByEmail(/*@RequestParam("email")String email*/) {
	  String email="u5526912@anu.edu.au";
	  log.info(email);
    try {
    	User user = userService.query(email);
    	return user;
    }
    catch (Exception ex) {
      log.error(ex);
      return null;
    }
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