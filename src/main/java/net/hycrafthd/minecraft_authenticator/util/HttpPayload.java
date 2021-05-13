package net.hycrafthd.minecraft_authenticator.util;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

public class HttpPayload {
	
	public static HttpPayload EMPTY = new HttpPayload(new byte[0]);
	
	private final byte[] bytes;
	
	private HttpPayload(byte[] bytes) {
		this.bytes = bytes;
	}
	
	public boolean hasContent() {
		return bytes.length > 0;
	}
	
	public int getSize() {
		return bytes.length;
	}
	
	public void write(OutputStream outputStream) throws IOException {
		outputStream.write(bytes);
	}
	
	public HttpPayload fromString(String payload) {
		return new HttpPayload(payload.getBytes(StandardCharsets.UTF_8));
	}
}