/*
 * Copyright 2014 Black Pepper Software
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package uk.co.blackpepper.support.spring.webmvc;

import java.io.IOException;
import java.util.Collections;

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ResponseStatusExceptionResolverTest {

	private ResponseStatusExceptionResolver exceptionResolver;
	
	@Before
	public void setUp() {
		exceptionResolver = new ResponseStatusExceptionResolver();
	}

	@Test
	public void doResolveExceptionSendsError() throws IOException {
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		exceptionResolver.doResolveException(null, response, null, new ResponseStatusException(HttpStatus.OK));
		
		verify(response).sendError(200);
	}
	
	@Test
	public void doResolveExceptionReturnsEmptyModelAndView() {
		ModelAndView actual = exceptionResolver.doResolveException(null, mock(HttpServletResponse.class), null,
			new ResponseStatusException(HttpStatus.OK));
		
		assertThat("viewName", actual.getViewName(), is(nullValue()));
		assertThat("model", actual.getModel(), is(Collections.<String, Object>emptyMap()));
	}

	@Test
	public void doResolveExceptionWhenSendErrorThrowsExceptionReturnsNull() throws IOException {
		HttpServletResponse response = mock(HttpServletResponse.class);
		doThrow(IOException.class).when(response).sendError(anyInt());
		
		ModelAndView actual = exceptionResolver.doResolveException(null, response, null,
			new ResponseStatusException(HttpStatus.OK));
		
		assertThat(actual, is(nullValue()));
	}
	
	@Test
	public void doResolveExceptionWithDifferentExceptionReturnsNull() {
		ModelAndView actual = exceptionResolver.doResolveException(null, null, null, new Exception());
		
		assertThat(actual, is(nullValue()));
	}
}
