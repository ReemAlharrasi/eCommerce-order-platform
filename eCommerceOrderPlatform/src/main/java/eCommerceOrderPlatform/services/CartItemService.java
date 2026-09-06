package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Cart;
import eCommerceOrderPlatform.entities.CartItem;
import eCommerceOrderPlatform.entities.Product;
import eCommerceOrderPlatform.repositories.CartItemRepository;
import eCommerceOrderPlatform.repositories.CartRepository;
import eCommerceOrderPlatform.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CartItemService {

    CartItemRepository cartItemRepository;
    CartRepository cartRepository;
    ProductRepository productRepository;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository,
                           CartRepository cartRepository,
                           ProductRepository productRepository) {
        this.cartItemRepository = cartItemRepository;
        this.cartRepository = cartRepository;
        this.productRepository = productRepository;
    }

    // create
    public Long createCartItem(Integer quantity, Long cartId, Long productId) {
        CartItem cartItem = new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setCart(resolveCart(cartId));
        cartItem.setProduct(resolveProduct(productId));
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
    public CartItem updateCartItem(Long id, Integer quantity, Long cartId, Long productId) {
        CartItem cartItem = cartItemRepository.getCartItemById(id);
        if (cartItem == null) return new CartItem();
        cartItem.setQuantity(quantity);
        cartItem.setCart(resolveCart(cartId));
        cartItem.setProduct(resolveProduct(productId));
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

    private Cart resolveCart(Long cartId) {
        if (cartId == null) return null;
        return cartRepository.getCartById(cartId);
    }

    private Product resolveProduct(Long productId) {
        if (productId == null) return null;
        return productRepository.getProductById(productId);
    }
}
