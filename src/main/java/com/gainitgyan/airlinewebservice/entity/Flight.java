package com.gainitgyan.airlinewebservice.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "flight")
public class Flight {

	@Id
	@Column(name = "flight_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "flight_number", nullable = false)
	private String flightNumber;

	@Column(name = "capacity", nullable = false)
	private Integer capacity;

	@Column(name = "mfd_by", nullable = false)
	private String mfdBy;
	
	@Column(name = "mfd_on", nullable = false)
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
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Flight other = (Flight) obj;
		return Objects.equals(id, other.id);
	}

	
}
