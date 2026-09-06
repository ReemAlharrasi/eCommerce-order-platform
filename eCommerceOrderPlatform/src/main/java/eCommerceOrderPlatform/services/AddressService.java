package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Address;
import eCommerceOrderPlatform.entities.Customer;
import eCommerceOrderPlatform.repositories.AddressRepository;
import eCommerceOrderPlatform.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AddressService {

    AddressRepository addressRepository;
    CustomerRepository customerRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
        this.customerRepository = customerRepository;
    }

    // create
    public Long createAddress(String street, String city, String postalCode, String type, Long customerId) {
        Address address = new Address();
        address.setStreet(street);
        address.setCity(city);
        address.setPostalCode(postalCode);
        address.setType(type);
        address.setCustomer(resolveCustomer(customerId));
        address = addressRepository.save(address);
        return address.getId();
    }

    // get all
    public List<Address> getAllAddresses() {

        return addressRepository.getAllAddresses();
    }

    // get by id
    public Address getById(Long id) {
        Address address = addressRepository.getAddressById(id);
        if (address == null) return new Address();
        return address;
    }

    // update
    public Address updateAddress(Long id, String street, String city, String postalCode, String type, Long customerId) {
        Address address = addressRepository.getAddressById(id);
        if (address == null) return new Address();
        address.setStreet(street);
        address.setCity(city);
        address.setPostalCode(postalCode);
        address.setType(type);
        address.setCustomer(resolveCustomer(customerId));
        return addressRepository.save(address);
    }

    // delete
    public Boolean deleteById(Long id) {
        Address address = addressRepository.getAddressById(id);
        if (address == null) return false;
        address.setIsActive(false);
        address.setUpdatedDate(new Date());
        addressRepository.save(address);
        return true;
    }

    private Customer resolveCustomer(Long customerId) {
        if (customerId == null) return null;
        return customerRepository.getCustomerById(customerId);
    }
}