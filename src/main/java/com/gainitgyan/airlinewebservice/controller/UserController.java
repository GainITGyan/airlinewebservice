package com.gainitgyan.airlinewebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gainitgyan.airlinewebservice.dto.UserDto;
import com.gainitgyan.airlinewebservice.security.UserPrincipal;
import com.gainitgyan.airlinewebservice.service.IUserService;
import com.gainitgyan.airlinewebservice.util.JWTTokenUtil;

@RestController
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	AuthenticationManager authenticationManager;
	
	@Autowired
	JWTTokenUtil jwtTokenUtil;
	
	@PostMapping(path = {"/register-user"}, consumes = {MediaType.APPLICATION_JSON_VALUE} , produces= {MediaType.APPLICATION_JSON_VALUE})
	public EntityModel<UserDto> createUser(@RequestBody UserDto userDto) {
		userDto = userService.createUser(userDto);
		return EntityModel.of(userDto);
	}
	@PutMapping(path = {"/update-user"}, consumes = {MediaType.APPLICATION_JSON_VALUE} , produces= {MediaType.APPLICATION_JSON_VALUE})
	public EntityModel<UserDto> updateUser(@RequestBody UserDto userDto) {
		userDto = userService.updateUser(userDto);
		return EntityModel.of(userDto);
	}

	@PostMapping(path="/login" , consumes = {MediaType.APPLICATION_JSON_VALUE} , produces= {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserDto> login(@RequestBody UserDto userDto) {
		
		this.authenticate(userDto.getUserName(), userDto.getPassword());
		
		UserDto user = this.userService.findUserByUserName(userDto.getUserName());
		
		user.setPassword(null);
		
		String jwtToken = this.jwtTokenUtil.generateToken(new UserPrincipal(user));
		
		HttpHeaders headers = new HttpHeaders();
		headers.add("Authorization", "Bearer "+jwtToken);
		
		return ResponseEntity.ok().headers(headers).body(user);
		
	}
	private void authenticate(String userName, String password) {

		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userName, password));
		
	}
}
