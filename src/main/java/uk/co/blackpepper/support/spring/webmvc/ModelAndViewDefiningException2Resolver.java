package uk.co.blackpepper.support.spring.webmvc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

public class ModelAndViewDefiningException2Resolver extends AbstractHandlerExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
		Exception exception) {
		
		if (!(exception instanceof ModelAndViewDefiningException2)) {
			return null;
		}
		
		ModelAndViewDefiningException2 modelAndViewDefiningException = (ModelAndViewDefiningException2) exception;
		response.setStatus(modelAndViewDefiningException.getStatus().value());
		return modelAndViewDefiningException.getModelAndView();
	}
}
