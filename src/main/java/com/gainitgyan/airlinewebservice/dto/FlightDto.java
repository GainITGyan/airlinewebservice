package com.gainitgyan.airlinewebservice.dto;

import java.time.LocalDate;
import java.util.Objects;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.PositiveOrZero;

import org.springframework.hateoas.RepresentationModel;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gainitgyan.airlinewebservice.validation.FlightMfdBy;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(name = "FlightDto" , description = "Model Object for Flight Resource")
public class FlightDto extends RepresentationModel<FlightDto>{
	
	@Schema(name = "Flight Id" , description = "Flight Id of Flight Resource")
	private Integer id;

	@Schema(name = "Flight Number" , description = "Flight Number of Flight Resource")
	@NotNull
	private String flightNumber;

	@Schema(name = "Capacity" , description = "Flight seat capacity of Flight Resource")
	@NotNull
	@PositiveOrZero(message = "Invalid Capacity value")
	private Integer capacity;

	@Schema(name = "mfdBy" , description = "Manufactured by of Flight Resource")
	@NotNull
	@FlightMfdBy
	private String mfdBy;
	
	@Schema(name = "mfdOn" , description = "Manufactured On of Flight Resource")
	@NotNull
	@Past(message="Date cannnot be a future value")
	@JsonFormat(pattern = "MM/dd/yyyy")
	private LocalDate mfdOn;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public void setFlightNumber(String flightNumber) {
		this.flightNumber = flightNumber;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
	}

	public String getMfdBy() {
		return mfdBy;
	}

	public void setMfdBy(String mfdBy) {
		this.mfdBy = mfdBy;
	}

	public LocalDate getMfdOn() {
		return mfdOn;
	}

	public void setMfdOn(LocalDate mfdOn) {
		this.mfdOn = mfdOn;
	}

	@Override
	public int hashCode() {
		return Objects.hash(capacity, flightNumber, id, mfdBy, mfdOn);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FlightDto other = (FlightDto) obj;
		return Objects.equals(capacity, other.capacity) && Objects.equals(flightNumber, other.flightNumber)
				&& Objects.equals(id, other.id) && Objects.equals(mfdBy, other.mfdBy)
				&& Objects.equals(mfdOn, other.mfdOn);
	}

	@Override
	public String toString() {
		return "FlightDto [id=" + id + ", flightNumber=" + flightNumber + ", capacity=" + capacity + ", mfdBy=" + mfdBy
				+ ", mfdOn=" + mfdOn + "]";
	}
	
	
}
