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
