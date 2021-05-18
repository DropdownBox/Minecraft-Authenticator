package net.hycrafthd.minecraft_authenticator.microsoft;

import java.util.Optional;

import net.hycrafthd.minecraft_authenticator.login.User;

public class MicrosoftLoginResponse {
	
	public static MicrosoftLoginResponse ofSuccess(User user, String refreshToken) {
		return new MicrosoftLoginResponse(Optional.of(user), Optional.of(refreshToken), Optional.empty());
	}
	
	public static MicrosoftLoginResponse ofError(MicrosoftAuthenticationException exception, Optional<String> refreshToken) {
		return new MicrosoftLoginResponse(Optional.empty(), refreshToken, Optional.of(exception));
	}
	
	private final Optional<User> user;
	private final Optional<String> refreshToken;
	private final Optional<MicrosoftAuthenticationException> exception;
	
	private MicrosoftLoginResponse(Optional<User> user, Optional<String> refreshToken, Optional<MicrosoftAuthenticationException> exception) {
		this.user = user;
		this.refreshToken = refreshToken;
		this.exception = exception;
	}
	
	public boolean hasUser() {
		return user.isPresent();
	}
	
	public Optional<User> getUser() {
		return user;
	}
	
	public boolean hasRefreshToken() {
		return refreshToken.isPresent();
	}
	
	public Optional<String> getRefreshToken() {
		return refreshToken;
	}
	
	public boolean hasException() {
		return exception.isPresent();
	}
	
	public Optional<MicrosoftAuthenticationException> getException() {
		return exception;
	}
}