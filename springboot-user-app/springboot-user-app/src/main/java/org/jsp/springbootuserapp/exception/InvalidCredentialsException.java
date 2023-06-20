package org.jsp.springbootuserapp.exception;

public class InvalidCredentialsException extends RuntimeException {
	@Override
	public String getMessage() {
		return "Invalid Credentials";
	}
}
