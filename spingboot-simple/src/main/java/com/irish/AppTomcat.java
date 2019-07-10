package com.irish;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;

public class AppTomcat {

	public static void main(String[] args) throws ServletException, LifecycleException {
		start();
	}

	public static void start() throws ServletException, LifecycleException {
		//创建Tomcat容器和设置端口
		Tomcat tomcatServer = new Tomcat();
		tomcatServer.setPort(9090);
		
		StandardContext ctx = (StandardContext) tomcatServer.addWebapp("/", new File("src/main").getAbsolutePath());
		ctx.setReloadable(false);
		WebResourceRoot resources = new StandardRoot(ctx);
		
		File additionWebInfClasses = new File("target/classes");
		//告诉Tomcat项目的class目录，根目录
		resources.addPreResources(
				new DirResourceSet(resources, "/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(), "/"));
		//启动容器
		tomcatServer.start();
		tomcatServer.getServer().await();
		
	}
	
}
