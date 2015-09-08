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

import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class ModelAndViewDefiningException2ResolverTest {
	
	private ModelAndViewDefiningException2Resolver exceptionResolver;
	
	@Before
	public void setUp() {
		exceptionResolver = new ModelAndViewDefiningException2Resolver();
	}

	@Test
	public void doResolveExceptionSetsResponseStatus() {
		HttpServletResponse response = mock(HttpServletResponse.class);
		ModelAndViewDefiningException2 exception = new ModelAndViewDefiningException2(new ModelAndView(),
			HttpStatus.OK);
		
		exceptionResolver.doResolveException(null, response, null, exception);
		
		verify(response).setStatus(200);
	}
	
	@Test
	public void doResolveExceptionReturnsModelAndView() {
		HttpServletResponse response = mock(HttpServletResponse.class);
		ModelAndView expected = new ModelAndView();
		ModelAndViewDefiningException2 exception = new ModelAndViewDefiningException2(expected);
		
		ModelAndView actual = exceptionResolver.doResolveException(null, response, null, exception);
		
		assertThat(actual, is(expected));
	}

	@Test
	public void doResolveExceptionWithDifferentExceptionDoesNotSetResponseStatus() {
		HttpServletResponse response = mock(HttpServletResponse.class);
		
		exceptionResolver.doResolveException(null, response, null, new Exception());
		
		verify(response, never()).setStatus(anyInt());
	}
	
	@Test
	public void doResolveExceptionWithDifferentExceptionReturnsNull() {
		ModelAndView actual = exceptionResolver.doResolveException(null, null, null, new Exception());
		
		assertThat(actual, is(nullValue()));
	}
}
