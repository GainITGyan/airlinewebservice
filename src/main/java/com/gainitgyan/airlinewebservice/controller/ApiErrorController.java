package com.gainitgyan.airlinewebservice.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

@Controller
public class ApiErrorController implements ErrorController{

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	@RequestMapping(path="/error")
	public void globalError(HttpServletRequest request, HttpServletResponse response) {
		
		throw new ResponseStatusException(HttpStatus.valueOf(response.getStatus()));
	}
	
}
