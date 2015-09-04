package uk.co.blackpepper.support.spring.webmvc;

import org.junit.Test;
import org.springframework.http.HttpStatus;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ResponseStatusExceptionTest {

	@Test
	public void constructorSetsProperties() {
		ResponseStatusException actual = new ResponseStatusException(HttpStatus.OK);
		
		assertThat(actual.getStatus(), is(HttpStatus.OK));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorWithNullStatusThrowsException() {
		new ResponseStatusException(null);
	}
}
