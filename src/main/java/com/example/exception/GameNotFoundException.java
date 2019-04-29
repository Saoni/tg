package com.example.exception;

public class GameNotFoundException extends RuntimeException{
	private static final long serialVersionUID = 1L;

 public GameNotFoundException(Class<?> entityClass, Object id) {
		super(String.format("%s was not found for parameter %s", entityClass.getSimpleName(), id));
	}
}