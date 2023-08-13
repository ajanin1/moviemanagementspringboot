package com.bilgeadam.film.yonetim.sistemi.advice;

import java.util.HashMap;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class FilmAdvice {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public Map<String, String> handleInvalideArgument(ConstraintViolationException ex){
		
		Map<String, String> errorMap = new HashMap<>();
		
		for(ConstraintViolation<?> violation : ex.getConstraintViolations()) {
			errorMap.put(violation.getPropertyPath().toString(), violation.getMessage());
		}
		
		return errorMap;
	}
}
