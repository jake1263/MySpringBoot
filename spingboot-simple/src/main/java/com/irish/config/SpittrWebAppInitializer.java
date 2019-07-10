package com.irish.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class SpittrWebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	//初始化spring容器，加载中间层和数据层的组件
	protected Class<?>[] getRootConfigClasses() {

		return new Class[] { RootConfig.class };
	}

	//初始化Springmvc容器，加载控制器、视图解析器、处理器映射器等组件
	protected Class<?>[] getServletConfigClasses() {
		
		return new Class[] { WebConfig.class };
	}

	//拦截url映射 拦截所有请求
	protected String[] getServletMappings() {

		return new String[] { "/" };

	}

}
