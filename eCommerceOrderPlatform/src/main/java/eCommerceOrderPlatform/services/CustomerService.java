package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Customer;
import eCommerceOrderPlatform.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerService {
    CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    // create
    public Long createCustomer(String name, String email, String phoneNumber, String gender) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customer.setGender(gender);
        customer = customerRepository.save(customer);
        return customer.getId();
    }

    // get all
    public List<Customer> getAllCustomers() {
        return customerRepository.getAllCustomers();
    }

    // get by id
    public Customer getById(Long id) {
        Customer customer = customerRepository.getCustomerById(id);
        if (customer == null) return new Customer();
        return customer;
    }

    // update
    public Customer updateCustomer(Long id, String name, String email, String phoneNumber, String gender) {
        Customer customer = customerRepository.getCustomerById(id);
        if (customer == null) return new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);
        customer.setGender(gender);
        return customerRepository.save(customer);
    }

    // delete
    public Boolean deleteById(Long id) {
        Customer customer = customerRepository.getCustomerById(id);
        if (customer == null) return false;
        customer.setIsActive(false);
        customer.setUpdatedDate(new Date());
        customerRepository.save(customer);
        return true;
    }
}
