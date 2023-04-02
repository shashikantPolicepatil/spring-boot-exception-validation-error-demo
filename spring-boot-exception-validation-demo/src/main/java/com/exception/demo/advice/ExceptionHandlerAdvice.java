package com.exception.demo.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.exception.demo.dto.ResponseData;
import com.exception.demo.exception.UserNotFoundException;

@RestControllerAdvice
public class ExceptionHandlerAdvice {
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseData> userNotFoundException(UserNotFoundException ex) {
		return new ResponseEntity<ResponseData>(new ResponseData(HttpStatus.NOT_FOUND.toString(),ex.getMessage()),
				HttpStatus.OK);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> validationError(MethodArgumentNotValidException ex) {
		Map<String,String> errorMap = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error->{
			errorMap.put(error.getField(),error.getDefaultMessage());
		});
		return new ResponseEntity<>(errorMap,HttpStatus.BAD_REQUEST);
	}

}
