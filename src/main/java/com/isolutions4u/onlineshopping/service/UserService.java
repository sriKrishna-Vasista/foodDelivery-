package com.isolutions4u.onlineshopping.service;

import java.util.List;

import com.isolutions4u.onlineshopping.model.User;

public interface UserService {

	boolean saveUser(User user);

	User findUserByEmail(String email);
	
	User findUserById(int id);
	
	List<User> findAllRetailers(String role);

	String updateUser(User user);

}
