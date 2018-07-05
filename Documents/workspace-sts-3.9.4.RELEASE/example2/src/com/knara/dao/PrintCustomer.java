package com.knara.dao;
import java.util.ArrayList;

import com.knara.model.Customer;

public class PrintCustomer {
	public void printCustomerData(ArrayList<Customer> custList, int index) {
		Customer custPrint = custList.get(index);
		System.out.println("==========CUSTOMER INFO================");
		System.out.println("이름 : " + custPrint.getName());
		System.out.println("성별 : " + custPrint.getGender());
		System.out.println("이메일 : " + custPrint.getEmail());
		System.out.println("출생년도 : " + custPrint.getBirthYear());
		System.out.println("=======================================");
		
	}
}
