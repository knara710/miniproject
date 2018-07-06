package com.knara.myapp;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.knara.myapp.controller.CustomerController;
//import com.knara.myapp.service.CustomerService;
//import com.knara.myapp.service.ICustomerService;

public class CustomerMain {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config.xml");
		CustomerController custController = (CustomerController) context.getBean("custController");
		
		/*
		ICustomerService custService = new CustomerService();
		CustomerController custController = new CustomerController();
		*/
		
		//custController.setCustService(custService);
		custController.run("nara");
	}
}