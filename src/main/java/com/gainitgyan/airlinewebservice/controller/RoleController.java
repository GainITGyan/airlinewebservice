package com.gainitgyan.airlinewebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gainitgyan.airlinewebservice.dto.RoleDto;
import com.gainitgyan.airlinewebservice.service.IRoleService;

@RestController
public class RoleController {

	@Autowired
	private IRoleService roleService;

	@PostMapping(path = {"/create-role"} , consumes = {MediaType.APPLICATION_JSON_VALUE} , produces = {MediaType.APPLICATION_JSON_VALUE})
	public EntityModel<RoleDto> createRole(@RequestBody RoleDto roleDto) {
		roleDto = roleService.createRole(roleDto);
		return EntityModel.of(roleDto);
	}
}
