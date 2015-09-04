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
