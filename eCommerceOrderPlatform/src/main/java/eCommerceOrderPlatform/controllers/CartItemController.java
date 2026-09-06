package eCommerceOrderPlatform.controllers;

import eCommerceOrderPlatform.entities.CartItem;
import eCommerceOrderPlatform.services.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cartItem")
public class CartItemController {

    CartItemService cartItemService;

    @Autowired
    public CartItemController(CartItemService cartItemService) {
        this.cartItemService = cartItemService;
    }

    @PostMapping("add")
    public Long addCartItem(
            @RequestParam Integer quantity,
            @RequestParam(required = false) Long cartId,
            @RequestParam(required = false) Long productId) {
        return cartItemService.createCartItem(quantity, cartId, productId);
    }

    @GetMapping("getAll")
    public List<CartItem> getAllCartItems() {
        return cartItemService.getAllCartItems();
    }

    @GetMapping("getById")
    public CartItem getById(@RequestParam Long id) {
        return cartItemService.getById(id);
    }

    @PutMapping("update")
    public CartItem updateCartItem(
            @RequestParam Long id,
            @RequestParam Integer quantity,
            @RequestParam(required = false) Long cartId,
            @RequestParam(required = false) Long productId) {

        return cartItemService.updateCartItem(id, quantity, cartId, productId);
    }

    @DeleteMapping("delete")
    public Boolean deleteCartItem(@RequestParam Long id) {
        return cartItemService.deleteById(id);
    }
}
