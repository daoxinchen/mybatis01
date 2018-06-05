package aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop.controller.UserController;

public class TestSpring {
	@Test
	public void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		
		UserController userController = (UserController) context.getBean("userController");
		System.out.println(userController.getClass());
		userController.addUser();
		System.out.println(userController.getClass());
	}
	
	
}
