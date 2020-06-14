package com.gainitgyan.airlinewebservice.dto;

import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

public class FlightDto {
	private Integer id;

	private String flightNumber;

	private Integer capacity;

	private String mfdBy;
	
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
