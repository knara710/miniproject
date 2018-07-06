package com.knara.myapp.service;

import org.springframework.stereotype.Service;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
import java.util.Scanner;
import java.util.ArrayList;

import com.knara.myapp.dao.DeleteCustomer;
import com.knara.myapp.dao.InsertCustomer;
import com.knara.myapp.dao.PrintCustomer;
import com.knara.myapp.dao.UpdateCustomer;
import com.knara.myapp.model.Customer;

@Service
public class CustomerService implements ICustomerService{ 
	
	@Override
	public void run(String name) {
		
		
		ArrayList<Customer> custList = new ArrayList<Customer>();
		
		/*
		InsertCustomer incust = new InsertCustomer();
		PrintCustomer prcust = new PrintCustomer();
		DeleteCustomer decust = new DeleteCustomer();
		UpdateCustomer upcust = new UpdateCustomer();
		*/
		
	
		AbstractApplicationContext context = new GenericXmlApplicationContext("application-config.xml");
		InsertCustomer incust = context.getBean(InsertCustomer.class);
		PrintCustomer prcust = context.getBean(PrintCustomer.class);
		DeleteCustomer decust = context.getBean(DeleteCustomer.class);
		UpdateCustomer upcust = context.getBean(UpdateCustomer.class);
		
		
		Scanner scan = new Scanner(System.in);
		
		int count = 0;		
		int index = -1;

		while(true) {
			count = custList.size();
			System.out.printf("\n[INFO] 고객 수 : %d, 인덱스 : %d\n", count, index);
			System.out.println("메뉴를 입력하세요.");
			System.out.println("(I)nsert, (P)revious, (N)ext, " +
					"(C)urrent, (U)pdate, (D)elete, (Q)uit");
			System.out.print("메뉴 입력: ");
			String menu = scan.next();
			menu = menu.toLowerCase();	//입력한 문자열을 모두소문자로 변환
			switch(menu.charAt(0)) {
			case 'i':
				System.out.println("고객정보 입력을 시작합니다.");
				custList = incust.insertCustomerData(scan, custList);
				//insertCustomerData(scan, custList);
				System.out.println("고객정보를 입력했습니다.");
				break;
			case 'p' :
				System.out.println("이전 데이터를 출력합니다.");
				if(index <= 0) {
					System.out.println("이전 데이터가 존재하지 않습니다.");
				}else {
					index--;
					prcust.printCustomerData(custList, index);
				}
				break;
			case 'n' :
				System.out.println("다음 데이터를 출력합니다.");
				if(index >= count-1) {
					System.out.println("다음 데이터가 존재하지 않습니다.");
				}else {
					index++;
					prcust.printCustomerData(custList, index);
				}
				break;
			case 'c' :
				System.out.println("현재 데이터를 출력합니다.");
				if( (index >= 0) && (index < count)) {
					prcust.printCustomerData(custList, index);
				}else {
					System.out.println("출력할 데이터가 선택되지 않았습니다.");
				}
				break;			
			case 'u' :
				System.out.println("데이터를 수정합니다.");
				if( (index >= 0) && (index < count)) {
					System.out.println(index + "번째 데이터를 수정합니다.");
					custList = upcust.updateCustomerData(scan, custList, index);
				}else {
					System.out.println("수정할 데이터가 선택되지 않았습니다.");
				}
				break;
			case 'd' :
				System.out.println("데이터를 삭제합니다.");
				if( (index >= 0) && (index < count)) {
					System.out.println(index + "번째 데이터를 삭제합니다.");
					custList = decust.deleteCustomerData(custList, index);
					index--;
				}else {
					System.out.println("삭제할 데이터가 선택되지 않았습니다.");
				}
				break;
			case 'q' :
				System.out.println("프로그램을 종료합니다.");
				scan.close();	//Scanner 객체를 닫아준다.
				System.exit(0);	//프로그램을 종료시킨다.
				break;	
			default : 
				System.out.println("메뉴를 잘 못 입력했습니다.");	
			}//end switch
		}//end while
	}//end main

}
