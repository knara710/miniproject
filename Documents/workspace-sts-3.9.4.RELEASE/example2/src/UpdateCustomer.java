import java.util.ArrayList;
import java.util.Scanner;

public class UpdateCustomer {
	
	public ArrayList<Customer> updateCustomerData(Scanner scan, ArrayList<Customer> custList, int index) {
		Customer custUp = custList.get(index);
		System.out.println("---------UPDATE CUSTOMER INFO----------");
		System.out.print("이름(" + custUp.getName() + ") :");
		custUp.setName(scan.next());

		System.out.print("성별(" + custUp.getGender() + ") :");
		custUp.setGender(scan.next().charAt(0));

		System.out.print("이메일(" + custUp.getEmail() + ") :");
		custUp.setEmail(scan.next());

		System.out.print("출생년도(" + custUp.getBirthYear() + ") :");
		custUp.setBirthYear(scan.nextInt());		
		
		//고객 객체를 ArrayList에 저장
		return custList;
	}

}
