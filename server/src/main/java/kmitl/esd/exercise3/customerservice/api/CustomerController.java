
package kmitl.esd.exercise3.customerservice.api;
import kmitl.esd.exercise3.customerservice.model.CustomerDTO;
import kmitl.esd.exercise3.customerservice.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Web service for customer CRUD operations
 * Produce endpoints as a part of the server API
 * Controller reacts to requests, controls the workflow, and gives a response
 * RESTful webservice -> HTTP method calls
 */

@RestController
@RequestMapping("/customer")
public class CustomerController {

    /**
     * Function to get all of the customers
     * Can be called using GET method
     *
     * @return list of customers
     */

    @GetMapping("/findall")
    public List<CustomerDTO> getAllCustomers() {
        return CustomerService.INSTANCE.getAllCustomers();
    }

    /**
     * Function to create customer
     * Can be called using POST method
     *
     * @return customer
     */
    @PostMapping("/create")
    public CustomerDTO createCustomer(CustomerDTO customer){
            return CustomerService.INSTANCE.createCustomer(customer);
    }

    /**
     * Function to update customer
     * Can be called using PUT method
     *
     * @return customer
     */
    @PutMapping
    public CustomerDTO updateCustomer(CustomerDTO customer){
        return CustomerService.INSTANCE.updateCustomer(customer); // ToDo replace the existing customer

    }

    /**
     * Function to delete customer
     * Can be called using DELETE method
     *
     * @param customerId
     * @return boolean - the result of deletion
     */
    @DeleteMapping("/{id}")
    public Boolean deleteCustomer(@PathVariable("id") Long customerId){
   return CustomerService.INSTANCE.deleteCustomer(customerId);
    }
}