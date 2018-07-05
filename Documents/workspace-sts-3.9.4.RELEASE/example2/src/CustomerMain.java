import com.knara.controller.CustomerController;
import com.knara.service.CustomerService;
import com.knara.service.ICustomerService;

public class CustomerMain {
	
	public static void main(String[] args) {
		
		ICustomerService custService = new CustomerService();
		CustomerController custController = new CustomerController();
		
		custController.setCustService(custService);
		custController.run("nara");
	}
}