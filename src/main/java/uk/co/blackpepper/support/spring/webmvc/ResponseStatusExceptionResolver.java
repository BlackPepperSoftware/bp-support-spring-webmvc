package uk.co.blackpepper.support.spring.webmvc;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.AbstractHandlerExceptionResolver;

public class ResponseStatusExceptionResolver extends AbstractHandlerExceptionResolver {

	@Override
	protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
		Exception exception) {
		
		if (!(exception instanceof ResponseStatusException)) {
			return null;
		}
		
		ResponseStatusException responseStatusException = (ResponseStatusException) exception;
		
		try {
			response.sendError(responseStatusException.getStatus().value());
		}
		catch (IOException sendErrorException) {
			logException(sendErrorException, request);
			return null;
		}
		
		return new ModelAndView();
	}
}
