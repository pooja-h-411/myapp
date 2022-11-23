package com.foo.myapp.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.foo.myapp.model.request.UserDetailsRequestModel;
import com.foo.myapp.model.response.UserDetailsResponseModel;
import com.foo.myapp.service.UserService;
import com.foo.myapp.shared.dto.UserDTO;

@RestController
@RequestMapping("users")
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping
	public String getUser() {
		return "get user details";
	}

	@PostMapping
	public UserDetailsResponseModel createUser(@RequestBody UserDetailsRequestModel userDetails) {
		UserDetailsResponseModel returnValue = new UserDetailsResponseModel();

		UserDTO userDto = new UserDTO();
		BeanUtils.copyProperties(userDetails, userDto);
		UserDTO createdUser = userService.createUser(userDto);
		return returnValue;
	}

	@PutMapping
	public String updateUser() {
		return "update user";
	}

	@DeleteMapping
	public String deleteUser() {
		return "user deleted";
	}
}
