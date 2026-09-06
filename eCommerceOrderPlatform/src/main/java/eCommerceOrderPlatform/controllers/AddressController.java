package eCommerceOrderPlatform.controllers;

import eCommerceOrderPlatform.entities.Address;
import eCommerceOrderPlatform.services.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("address")
public class AddressController {

    AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @PostMapping("add")
    public Long addAddress(
            @RequestParam String street,
            @RequestParam String city,
            @RequestParam String postalCode,
            @RequestParam String type,
            @RequestParam(required = false) Long customerId) {

        return addressService.createAddress(
                street, city, postalCode, type, customerId
        );
    }

    @GetMapping("getAll")
    public List<Address> getAllAddresses() {
        return addressService.getAllAddresses();
    }

    @GetMapping("getById")
    public Address getById(@RequestParam Long id) {
        return addressService.getById(id);
    }

    @PutMapping("update")
    public Address updateAddress(
            @RequestParam Long id,
            @RequestParam String street,
            @RequestParam String city,
            @RequestParam String postalCode,
            @RequestParam String type,
            @RequestParam(required = false) Long customerId) {

        return addressService.updateAddress(
                id, street, city, postalCode, type, customerId
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteAddress(@RequestParam Long id) {
        return addressService.deleteById(id);
    }
}
