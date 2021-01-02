package com.gainitgyan.airlinewebservice.dto;

public class AuthorityDto {

	private String name;

	public AuthorityDto() {
	}
	
	public AuthorityDto(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "AuthorityDto [name=" + name + "]";
	}

	
}
