package com.gainitgyan.airlinewebservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.gainitgyan.airlinewebservice.entity.Flight;

@Repository
public interface IFlightRepository extends CrudRepository<Flight, Integer>{

	Flight findByFlightNumber(String flightNumber);
	
}
