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
	public void create(User newUser);
	public void remove(User removedUser);
	public void update(User updatedUser);
	public User query(String email);

}
