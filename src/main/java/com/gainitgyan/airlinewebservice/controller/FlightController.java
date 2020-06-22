package com.gainitgyan.airlinewebservice.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

import org.springframework.beans.factory.annotation.Autowired;
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

	@Autowired
	IFlightService flightService;

	// Http GET method - Read operation
	@GetMapping(path = "/flight/{id}")
	public FlightDto getFlight(@PathVariable(name = "id") @Positive Integer flightId) {
		return flightService.getFlight(flightId);
	}

	@GetMapping(path = "/flight")
	public List<FlightDto> getAllFlights() {
		return flightService.getAllFlights();
	}

	@GetMapping(path = "/flight/flightData/{flightNumber}")
	public FlightDto getFlightByFlightNumber(@PathVariable(name = "flightNumber") String flightNumber) {
		return flightService.getFlightByflightNumber(flightNumber);
	}

	// Http post method - Create operation
	@PostMapping(path = "/flight")
	public FlightDto createFlight(@RequestBody @Valid FlightDto flightDto) {

		return flightService.createFlight(flightDto);
	}

	// Http put method - Update operation
	@PutMapping(path = "/flight")
	public FlightDto updateFlight(@RequestBody @Valid FlightDto flightDto) {
		return flightService.updateFlight(flightDto);
	}

	// Http delete method - delete operation
	@DeleteMapping(path = "/flight/delete/{id}")
	public void deleteFlight(@PathVariable(name = "id") @Positive Integer flightId) {
		flightService.deleteFlight(flightId);
	}

}
