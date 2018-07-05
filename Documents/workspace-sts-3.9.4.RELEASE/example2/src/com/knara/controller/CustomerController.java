package com.knara.controller;
import com.knara.service.ICustomerService;
//import com.knara.service.CustomerService;

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
