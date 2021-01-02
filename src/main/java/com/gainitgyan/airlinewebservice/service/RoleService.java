package com.gainitgyan.airlinewebservice.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gainitgyan.airlinewebservice.dto.AuthorityDto;
import com.gainitgyan.airlinewebservice.dto.RoleDto;
import com.gainitgyan.airlinewebservice.entity.Authority;
import com.gainitgyan.airlinewebservice.entity.Role;
import com.gainitgyan.airlinewebservice.repository.IAuthorityRepository;
import com.gainitgyan.airlinewebservice.repository.IRoleRepository;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	private IRoleRepository roleRepo;
	
	@Autowired
	private IAuthorityRepository authorityRepo;

	@Override
	public RoleDto createRole(RoleDto roleDto) {
		
		Role  role = new Role();
		role.setName(roleDto.getName());
		role.setAuthorities(roleDto.getAuthorities().stream().map(a-> {
			Authority authority = authorityRepo.findByName(a.getName());
			if(authority == null) {
				authority = authorityRepo.save(new Authority(a.getName()));
			}
			return authority;
		}).collect(Collectors.toSet()));
		
		System.out.println("RoleDto = "+roleDto);
		
		roleRepo.save(role);
		
		System.out.println("---------------------------");
		
		roleDto.setName(role.getName());
		
		roleDto.setAuthorities(role.getAuthorities().stream().map(a -> new AuthorityDto(a.getName())).collect(Collectors.toSet()));
		
		System.out.println("RoleDto in response = "+ roleDto);
		
		return roleDto;
	}

}
