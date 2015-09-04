package uk.co.blackpepper.support.spring.webmvc;

import org.junit.Test;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.hasEntry;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.mock;

public class ModelAndViewFactoryTest {

	@Test
	public void newModelAndViewSetsProperties() {
		BindingResult errors = mock(BindingResult.class);
		
		ModelAndView actual = ModelAndViewFactory.newModelAndView("x", "y", "z", errors);
		
		assertThat("viewName", actual.getViewName(), is("x"));
		assertThat("model", actual.getModel(), hasEntry("y", (Object) "z"));
		assertThat("errors", actual.getModel(), hasEntry(BindingResult.MODEL_KEY_PREFIX + "y", (Object) errors));
	}
}
