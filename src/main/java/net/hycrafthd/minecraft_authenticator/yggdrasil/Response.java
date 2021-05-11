package net.hycrafthd.minecraft_authenticator.yggdrasil;

import java.util.Optional;

import net.hycrafthd.minecraft_authenticator.yggdrasil.api.ErrorResponse;

public class Response<T> {
	
	private final Optional<T> response;
	private final Optional<ErrorResponse> errorResponse;
	private final Optional<Throwable> exception;
	
	public Response(T response) {
		this.response = Optional.of(response);
		errorResponse = Optional.empty();
		exception = Optional.empty();
	}
	
	public Response(ErrorResponse error) {
		response = Optional.empty();
		this.errorResponse = Optional.of(error);
		exception = Optional.empty();
	}
	
	public Response(Throwable exception) {
		response = Optional.empty();
		errorResponse = Optional.empty();
		this.exception = Optional.of(exception);
	}
	
	public Optional<T> getResponse() {
		return response;
	}
	
	public boolean hasError() {
		return errorResponse.isPresent();
	}
	
	public Optional<ErrorResponse> getErrorResponse() {
		return errorResponse;
	}
	
	public boolean hasException() {
		return exception.isPresent();
	}
	
	public Optional<Throwable> getException() {
		return exception;
	}
	
}
