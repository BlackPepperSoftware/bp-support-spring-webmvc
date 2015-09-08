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
