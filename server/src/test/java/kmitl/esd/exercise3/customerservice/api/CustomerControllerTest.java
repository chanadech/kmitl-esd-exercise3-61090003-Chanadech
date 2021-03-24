package kmitl.esd.exercise3.customerservice.api;

import kmitl.esd.exercise3.customerservice.model.CustomerDTO;
import kmitl.esd.exercise3.customerservice.web.CustomerController;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * class for CustomerController testing
 */
class CustomerControllerTest {

    private CustomerController customerController = new CustomerController();

    /**
     * Test for getting all customers
     */
    @Test
    void getAllCustomers() {
        List<CustomerDTO> allCustomers = customerController.getAllCustomers();
        assertEquals(allCustomers.size(),10);
    }

    /**
     * method for creating customer's testing
     */
    @Test
    void createCustomer() {
        customerController.createCustomer(new CustomerDTO(3L,"Dech",20L));
        assertEquals(customerController.getAllCustomers().size(),5);
        customerController.deleteCustomer(7L);
    }

    /**
     * Test for update customer
     */
    @Test
    void updateCustomer() {
        CustomerDTO newCustomer = customerController.createCustomer(new CustomerDTO(4L,"Mike",50L));
        newCustomer.setName("Dech");

        CustomerDTO updateCustomer = customerController.updateCustomer(newCustomer);
        assertEquals(updateCustomer.getName(),"Dech");
        customerController.deleteCustomer(4L);

    }

    /**
     * method for deleting customer's testing
     */
    @Test
    void deleteCustomer() {
        assertEquals (customerController.getAllCustomers().size(),6);
        customerController.deleteCustomer(2L);
        assertEquals(customerController.getAllCustomers().size(),1);
        customerController.createCustomer(new CustomerDTO(1L,"Mike2", 70L));
    }
}