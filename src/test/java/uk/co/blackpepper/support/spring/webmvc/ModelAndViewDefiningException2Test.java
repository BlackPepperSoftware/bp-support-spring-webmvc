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

import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ModelAndViewDefiningException2Test {

	@Test
	public void constructorWithModelAndViewSetsProperties() {
		ModelAndView modelAndView = new ModelAndView();
		
		ModelAndViewDefiningException2 actual = new ModelAndViewDefiningException2(modelAndView);
		
		assertThat("modelAndView", actual.getModelAndView(), is(modelAndView));
		assertThat("status", actual.getStatus(), is(HttpStatus.OK));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorWithModelAndViewAndNullModelAndViewThrowsException() {
		new ModelAndViewDefiningException2(null);
	}
	
	@Test
	public void constructorWithModelAndViewAndStatusSetsProperties() {
		ModelAndView modelAndView = new ModelAndView();
		
		ModelAndViewDefiningException2 actual = new ModelAndViewDefiningException2(modelAndView, HttpStatus.NOT_FOUND);
		
		assertThat("modelAndView", actual.getModelAndView(), is(modelAndView));
		assertThat("status", actual.getStatus(), is(HttpStatus.NOT_FOUND));
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorWithModelAndViewAndStatusAndNullModelAndViewThrowsException() {
		new ModelAndViewDefiningException2(null, HttpStatus.NOT_FOUND);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void constructorWithModelAndViewAndStatusAndNullStatusThrowsException() {
		new ModelAndViewDefiningException2(new ModelAndView(), null);
	}
}
