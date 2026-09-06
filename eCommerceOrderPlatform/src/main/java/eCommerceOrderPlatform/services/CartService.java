package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Cart;
import eCommerceOrderPlatform.repositories.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartService {

    CartRepository cartRepository;

    @Autowired
    public CartService(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    // create
    public Long createCart() {
        Cart cart = new Cart();
        cart.setCreatedDate(new Date());
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

    // delete
    public Boolean deleteById(Long id) {
        Cart cart = cartRepository.getCartById(id);
        if (cart == null) return false;
        cart.setIsActive(false);
        cart.setUpdatedDate(new Date());
        cartRepository.save(cart);
        return true;
    }
}