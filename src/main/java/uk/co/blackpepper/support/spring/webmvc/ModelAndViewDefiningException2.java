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
