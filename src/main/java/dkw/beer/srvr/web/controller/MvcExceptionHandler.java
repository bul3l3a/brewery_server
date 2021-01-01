package dkw.beer.srvr.web.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
 * The purpose of this class is to keep us from duplicating code everywhere that deals 
 * with handling ConstraintViolationExceptions.
 * 
 * So, we are going to add "advice" to each of those controllers that need to handle
 * these types of errors
 */
@ControllerAdvice
public class MvcExceptionHandler {

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<List<String>> validationErrorHandler(ConstraintViolationException e) {
		List<String> errors = new ArrayList<>(e.getConstraintViolations().size());
		e.getConstraintViolations().forEach(violation -> {
			errors.add(String.format("%s : %s", violation.getPropertyPath(), violation.getMessage()));
		});
		return new ResponseEntity<List<String>>(errors, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(BindException.class)
	public ResponseEntity<List> bindExceptionErrorHandler(BindException e) {
		List<String> errors = new ArrayList<>();
		return new ResponseEntity<List>(e.getAllErrors(), HttpStatus.BAD_REQUEST);
	}

	
}
