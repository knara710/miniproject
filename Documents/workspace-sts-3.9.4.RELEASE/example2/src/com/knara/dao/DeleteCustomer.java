package com.knara.dao;
import java.util.ArrayList;

import com.knara.model.Customer;

public class DeleteCustomer {
	public ArrayList<Customer> deleteCustomerData(ArrayList<Customer> custList, int index) {
		custList.remove(index);
		return custList;
	}
}
