package uk.co.blackpepper.support.spring.webmvc;

import org.springframework.http.HttpStatus;
import org.springframework.util.Assert;
import org.springframework.web.servlet.ModelAndView;

/**
 * A variant of Spring's {@code ModelAndViewDefiningException} that can hold a HTTP status.
 * <p>
 * To be used in conjunction with {@code ModelAndViewDefiningException2Resolver}. Note that this exception does not
 * extend {@code ModelAndViewDefiningException} since it would then be handled instead by the {@code DispatcherServlet}.
 * 
 * @see org.springframework.web.servlet.ModelAndViewDefiningException
 * @see ModelAndViewDefiningException2Resolver
 */
@SuppressWarnings("serial")
public class ModelAndViewDefiningException2 extends RuntimeException {

	private final ModelAndView modelAndView;
	
	private final HttpStatus status;
	
	public ModelAndViewDefiningException2(ModelAndView modelAndView) {
		this(modelAndView, HttpStatus.OK);
	}
	
	public ModelAndViewDefiningException2(ModelAndView modelAndView, HttpStatus status) {
		Assert.notNull(modelAndView, "ModelAndView must not be null in ModelAndViewDefiningException2");
		Assert.notNull(status, "HttpStatus must not be null in ModelAndViewDefiningException2");
		this.modelAndView = modelAndView;
		this.status = status;
	}
	
	public ModelAndView getModelAndView() {
		return modelAndView;
	}
	
	public HttpStatus getStatus() {
		return status;
	}
}
