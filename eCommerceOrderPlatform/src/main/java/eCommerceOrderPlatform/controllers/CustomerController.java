package eCommerceOrderPlatform.controllers;

import eCommerceOrderPlatform.entities.Customer;
import eCommerceOrderPlatform.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("customer")
public class CustomerController {

    CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @PostMapping("add")
    public Long addCustomer(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phoneNumber,
            @RequestParam String gender,
            @RequestParam(required = false) Long storeId) {

        return customerService.createCustomer(
                name, email, phoneNumber, gender, storeId
        );
    }

    @GetMapping("getAll")
    public List<Customer> getAllCustomers() {
        return customerService.getAllCustomers();
    }

    @GetMapping("getById")
    public Customer getById(@RequestParam Long id) {
        return customerService.getById(id);
    }

    @PutMapping("update")
    public Customer updateCustomer(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String phoneNumber,
            @RequestParam String gender,
            @RequestParam(required = false) Long storeId) {

        return customerService.updateCustomer(
                id, name, email, phoneNumber, gender, storeId
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteCustomer(@RequestParam Long id) {
        return customerService.deleteById(id);
    }
}
