package com.gainitgyan.airlinewebservice.service;

import java.util.List;

import com.gainitgyan.airlinewebservice.dto.FlightDto;

public interface IFlightService {

	public FlightDto createFlight(FlightDto flightDto);

	public FlightDto getFlight(Integer flightId);

	public FlightDto updateFlight(FlightDto flightDto);

	public void deleteFlight(Integer flightId);

	public List<FlightDto> getAllFlights();

	public FlightDto getFlightByflightNumber(String flightNumber);

}
