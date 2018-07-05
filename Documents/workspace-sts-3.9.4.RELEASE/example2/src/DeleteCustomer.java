import java.util.ArrayList;

public class DeleteCustomer {
	public ArrayList<Customer> deleteCustomerData(ArrayList<Customer> custList, int index) {
		custList.remove(index);
		return custList;
	}
}
