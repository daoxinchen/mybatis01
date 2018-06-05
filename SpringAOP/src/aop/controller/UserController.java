package aop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import aop.service.UserService;

@Controller
public class UserController {
	
	@Autowired 
	private UserService userService;
	public void addUser() {
		userService.addUser();
	}
	
}
