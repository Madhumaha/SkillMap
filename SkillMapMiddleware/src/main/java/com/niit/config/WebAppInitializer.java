package com.niit.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import com.niit.SkillMapBackend.config.DbConfig;

public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
	public WebAppInitializer() {
		System.out.println("hi");
	}

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { WebAppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[] { DbConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("inside");
		return new String[] { "/" };
	}

}
