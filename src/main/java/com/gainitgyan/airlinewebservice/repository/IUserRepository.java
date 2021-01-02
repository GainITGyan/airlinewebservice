package com.gainitgyan.airlinewebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gainitgyan.airlinewebservice.entity.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Integer>{
	
	User findUserByUserName(String userName);
	
	User findUserByEmailId(String emailId);

}
