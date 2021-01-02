package com.gainitgyan.airlinewebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gainitgyan.airlinewebservice.entity.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer>{

	Role findByName(String name);
	
}
