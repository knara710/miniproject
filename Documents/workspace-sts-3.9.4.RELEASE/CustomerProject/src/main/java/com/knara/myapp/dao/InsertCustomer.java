package com.knara.myapp.dao;
import java.util.ArrayList;
import java.util.Scanner;

import com.knara.myapp.model.Customer;

public class InsertCustomer {
	
	
	public ArrayList<Customer> insertCustomerData(Scanner scan, ArrayList<Customer> custList) {
		System.out.print("이름 : ");	
		String name = scan.next();
		System.out.print("성별(M/F) : ");	
		char gender = scan.next().charAt(0);
		System.out.print("이메일 : ");	
		String email = scan.next();
		System.out.print("출생년도 : ");	
		int birthYear = scan.nextInt();

		//입력받은 데이터로 고객 객체를 생성
		Customer custNew = new Customer(name, gender, email, birthYear);
		
		//고객 객체를 ArrayList에 저장
		custList.add(custNew);
		
		
		
		return custList;
	}
	
}

