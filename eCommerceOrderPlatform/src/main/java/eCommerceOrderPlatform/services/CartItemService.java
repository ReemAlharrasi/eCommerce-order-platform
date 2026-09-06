package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.CartItem;
import eCommerceOrderPlatform.repositories.CartItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartItemService {

    CartItemRepository cartItemRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository) {
        this.cartItemRepository = cartItemRepository;
    }

    // create
    public Long createCartItem(Integer quantity) {
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem = cartItemRepository.save(cartItem);
        return cartItem.getId();
    }

    // get all
    public List<CartItem> getAllCartItems() {
        return cartItemRepository.getAllCartItems();
    }

    // get by id
    public CartItem getById(Long id) {
        CartItem cartItem = cartItemRepository.getCartItemById(id);
        if (cartItem == null) return new CartItem();
        return cartItem;
    }

    // update
    public CartItem updateCartItem(Long id, Integer quantity) {
        CartItem cartItem = cartItemRepository.getCartItemById(id);
        if (cartItem == null) return new CartItem();
        cartItem.setQuantity(quantity);
        return cartItemRepository.save(cartItem);
    }

    // delete
    public Boolean deleteById(Long id) {
        CartItem cartItem = cartItemRepository.getCartItemById(id);
        if (cartItem == null) return false;
        cartItem.setIsActive(false);
        cartItem.setUpdatedDate(new Date());
        cartItemRepository.save(cartItem);

        return true;
    }
}