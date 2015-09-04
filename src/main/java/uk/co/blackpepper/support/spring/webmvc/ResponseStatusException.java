package uk.co.blackpepper.support.spring.webmvc;

import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;

@SuppressWarnings("serial")
public class ResponseStatusException extends RuntimeException {

	private final HttpStatus status;
	
	public ResponseStatusException(HttpStatus status) {
		Assert.notNull(status, "HttpStatus must not be null in ResponseStatusException");
		this.status = status;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
}
