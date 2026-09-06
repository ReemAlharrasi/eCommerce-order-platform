package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Cart;
import eCommerceOrderPlatform.entities.Customer;
import eCommerceOrderPlatform.repositories.CartRepository;
import eCommerceOrderPlatform.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartService {

    CartRepository cartRepository;
    CustomerRepository customerRepository;

    @Autowired
    public CartService(CartRepository cartRepository, CustomerRepository customerRepository) {
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    // create
    public Long createCart(Long customerId) {
        Cart cart = new Cart();
        cart.setCartCreatedDate(new Date());
        cart.setCustomer(resolveCustomer(customerId));
        cart = cartRepository.save(cart);
        return cart.getId();
    }

    // get all
    public List<Cart> getAllCarts() {
        return cartRepository.getAllCarts();
    }

    // get by id
    public Cart getById(Long id) {
        Cart cart = cartRepository.getCartById(id);
        if (cart == null) return new Cart();
        return cart;
    }

    // update (reassign the customer a cart belongs to)
    public Cart updateCart(Long id, Long customerId) {
        Cart cart = cartRepository.getCartById(id);
        if (cart == null) return new Cart();
        cart.setCustomer(resolveCustomer(customerId));
        return cartRepository.save(cart);
    }

    // delete
    public Boolean deleteById(Long id) {
        Cart cart = cartRepository.getCartById(id);
        if (cart == null) return false;
        cart.setIsActive(false);
        cart.setUpdatedDate(new Date());
        cartRepository.save(cart);
        return true;
    }

    private Customer resolveCustomer(Long customerId) {
        if (customerId == null) return null;
        return customerRepository.getCustomerById(customerId);
    }
}
