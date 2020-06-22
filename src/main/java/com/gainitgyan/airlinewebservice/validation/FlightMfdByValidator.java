package com.gainitgyan.airlinewebservice.validation;

import java.util.Arrays;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FlightMfdByValidator implements ConstraintValidator<FlightMfdBy, String> {

	List<String> approvedMfd = Arrays.asList("aaa", "bbb", "ccc");

	@Override
	public boolean isValid(String value, ConstraintValidatorContext context) {

		if (value == null || value.isBlank())
			return false;

		if (approvedMfd.contains(value))
			return true;
		else
			return false;

	}
}
