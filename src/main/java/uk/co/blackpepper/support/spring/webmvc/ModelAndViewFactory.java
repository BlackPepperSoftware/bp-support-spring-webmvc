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

import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

public final class ModelAndViewFactory {
	
	private ModelAndViewFactory() {
		throw new AssertionError();
	}

	public static ModelAndView newModelAndView(String viewName, String modelName, Object modelObject,
		BindingResult modelErrors) {
		ModelAndView modelAndView = new ModelAndView(viewName);
		return addObject(modelAndView, modelName, modelObject, modelErrors);
	}
	
	private static ModelAndView addObject(ModelAndView modelAndView, String attributeName, Object attributeValue,
		BindingResult attributeErrors) {
		return modelAndView.addObject(attributeName, attributeValue)
			.addObject(BindingResult.MODEL_KEY_PREFIX + attributeName, attributeErrors);
	}
}
