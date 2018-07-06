package com.knara.myapp.dao;
import java.util.ArrayList;

import com.knara.myapp.model.Customer;

public class DeleteCustomer {
	public ArrayList<Customer> deleteCustomerData(ArrayList<Customer> custList, int index) {
		custList.remove(index);
		return custList;
	}
}
