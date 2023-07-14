package com.emandi.user.service;


import com.emandi.user.dto.LoginDTO;
import com.emandi.user.dto.UserDTO;
import com.emandi.user.model.User;

import java.util.List;

public interface UserService {
	User registerUser(UserDTO userDTO);
	void deleteUser(Integer id);
	User updateUser(Integer id, User user);
	public UserDTO findByUserId(Integer id);
	List<User> findAllUserDetails();

	String login(LoginDTO loginDTO);
}
