package com.gainitgyan.airlinewebservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.gainitgyan.airlinewebservice.dto.UserDto;

public interface IUserService extends UserDetailsService{

	public UserDto createUser(UserDto userDto);
	public UserDto updateUser(UserDto userDto);
	public UserDto findUserByUserName(String userName);
}
