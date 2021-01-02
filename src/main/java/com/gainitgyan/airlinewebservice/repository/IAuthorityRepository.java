package com.gainitgyan.airlinewebservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gainitgyan.airlinewebservice.entity.Authority;

@Repository
public interface IAuthorityRepository extends JpaRepository<Authority, Integer>{

	Authority findByName(String name);
}
