package com.isolutions4u.onlineshopping.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.isolutions4u.onlineshopping.model.Product;
import com.isolutions4u.onlineshopping.model.User;
import com.isolutions4u.onlineshopping.repository.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Qualifier("userRepository")
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public boolean saveUser(User user) {
		// TODO Auto-generated method stub
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		userRepository.saveAndFlush(user);
		return true;
	}
	
	@Override
	public String updateUser(User user) {
		// TODO Auto-generated method stub
		userRepository.saveAndFlush(user);
		return "Product Updated Sucessfully";
	}

	@Override
	public User findUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepository.findUserByEmail(email);
	}
	
	@Override
	public List<User> findAllRetailers(String role) {
		// TODO Auto-generated method stub
		return userRepository.findUserByRole(role);
	}
	
	@Override
	public User findUserById(int id) {
		return userRepository.findUserById(id);
	}

}
