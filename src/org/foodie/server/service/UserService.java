package org.foodie.server.service;

import org.foodie.server.entity.User;
import org.springframework.stereotype.Service;

/**
 * 
 * @author Danyang Li
 *
 */
//@Service
public interface UserService {	
	public String create(User newUser);
	public String remove(User removedUser);
	public String update(User updatedUser);
	public User query(String field);

}
