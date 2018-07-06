package com.knara.myapp.controller;
import org.springframework.stereotype.Controller;

import com.knara.myapp.service.ICustomerService;
//import com.knara.service.CustomerService;

@Controller
public class CustomerController {
	
	//ICustomerService custService = new CustomerService();
	
	ICustomerService custService;

	public ICustomerService getCustService() {
		return custService;
	}

	public void setCustService(ICustomerService custService) {
		this.custService = custService;
	}
	
	public void run(String name) {
		custService.run(name);
	}
}
