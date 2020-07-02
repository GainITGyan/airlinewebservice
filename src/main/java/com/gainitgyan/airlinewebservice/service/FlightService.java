package com.gainitgyan.airlinewebservice.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.gainitgyan.airlinewebservice.dto.FlightDto;
import com.gainitgyan.airlinewebservice.entity.Flight;
import com.gainitgyan.airlinewebservice.repository.IFlightRepository;

@Service
public class FlightService implements IFlightService {

	@Autowired
	IFlightRepository flightRepo;

	@Override
	public FlightDto createFlight(FlightDto flightDto) {

		Flight flight = new Flight();
		BeanUtils.copyProperties(flightDto, flight);

		flight = flightRepo.save(flight);

		BeanUtils.copyProperties(flight, flightDto);

		return flightDto;
	}

	@Override
	public FlightDto getFlight(Integer flightId) {
		Flight flight = flightRepo.findById(flightId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight Not Found."));

		FlightDto dto = new FlightDto();
		BeanUtils.copyProperties(flight, dto);

		return dto;
	}

	@Override
	public FlightDto updateFlight(FlightDto flightDto) {

		Flight flight = flightRepo.findById(flightDto.getId())
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight Not Found."));
		BeanUtils.copyProperties(flightDto, flight);

		flight = flightRepo.save(flight);

		BeanUtils.copyProperties(flight, flightDto);

		return flightDto;
	}

	@Override
	public void deleteFlight(Integer flightId) {
		flightRepo.findById(flightId)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Flight Not Found."));
		
		flightRepo.deleteById(flightId);

	}

	@Override
	public List<FlightDto> getAllFlights() {
		Iterable<Flight> itreable = flightRepo.findAll();

		List<FlightDto> flights = StreamSupport.stream(itreable.spliterator(), false).map(flight -> {
			FlightDto dto = new FlightDto();
			BeanUtils.copyProperties(flight, dto);
			return dto;
		}).collect(Collectors.toList());

		return flights;
	}

	@Override
	public FlightDto getFlightByflightNumber(String flightNumber) {

		Flight flight = flightRepo.findByFlightNumber(flightNumber);

		FlightDto dto = new FlightDto();
		BeanUtils.copyProperties(flight, dto);

		return dto;
	}
}
