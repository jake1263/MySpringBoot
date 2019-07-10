package com.irish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.irish.service.UserService;

@RestController
public class IndexController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/index", produces = "text/html;charset=UTF-8")
	public String index() {
		return   userService.index();
	}

	
}
