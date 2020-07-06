package com.gainitgyan.airlinewebservice.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gainitgyan.airlinewebservice.dto.FlightDto;
import com.gainitgyan.airlinewebservice.service.IFlightService;

@RestController
@Validated
public class FlightController {

	private static final Logger logger = LogManager.getLogger(FlightController.class);
	
	@Autowired
	IFlightService flightService;

	// Http GET method - Read operation
	@GetMapping(path = "/flight/{id}")
	public EntityModel<FlightDto> getFlight(@PathVariable(name = "id") @Positive Integer flightId) {
		
		Link link = linkTo(methodOn(FlightController.class).getFlight(flightId)).withSelfRel();
		FlightDto dto = flightService.getFlight(flightId);
		dto.add(link);
		
		return EntityModel.of(dto);
	}

	@GetMapping(path = "/flight")
	public CollectionModel<FlightDto> getAllFlights() {
		
		List<FlightDto> list = flightService.getAllFlights();
		for(FlightDto dto : list) {
			Link link = linkTo(methodOn(FlightController.class).getFlight(dto.getId())).withSelfRel();
			dto.add(link);
		}
		Link link = linkTo(methodOn(FlightController.class).getAllFlights()).withSelfRel();
		return CollectionModel.of(list,link);
	}

	@GetMapping(path = "/flight/flightData/{flightNumber}")
	public EntityModel<FlightDto> getFlightByFlightNumber(@PathVariable(name = "flightNumber") String flightNumber) {
		FlightDto dto = flightService.getFlightByflightNumber(flightNumber);
		Link link = linkTo(methodOn(FlightController.class).getFlightByFlightNumber(flightNumber)).withSelfRel();
		dto.add(link);
		
		return EntityModel.of(dto);
	}

	// Http post method - Create operation
	@PostMapping(path = "/flight")
	public EntityModel<FlightDto> createFlight(@RequestBody @Valid FlightDto flightDto) {

		FlightDto dto = flightService.createFlight(flightDto);
		Link link = linkTo(methodOn(FlightController.class).getFlight(dto.getId())).withSelfRel();
		dto.add(link);		
		
		return EntityModel.of(dto);
	}

	// Http put method - Update operation
	@PutMapping(path = "/flight")
	public EntityModel<FlightDto> updateFlight(@RequestBody @Valid FlightDto flightDto) {
		
		FlightDto dto = flightService.updateFlight(flightDto);
		
		Link link = linkTo(methodOn(FlightController.class).getFlight(dto.getId())).withSelfRel();
		dto.add(link);		
		
		return EntityModel.of(dto);
	}

	// Http delete method - delete operation
	@DeleteMapping(path = "/flight/delete/{id}")
	public void deleteFlight(@PathVariable(name = "id") @Positive Integer flightId) {
		flightService.deleteFlight(flightId);
	}

}
