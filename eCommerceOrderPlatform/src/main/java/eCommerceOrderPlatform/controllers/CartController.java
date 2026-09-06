package eCommerceOrderPlatform.controllers;

import eCommerceOrderPlatform.entities.Cart;
import eCommerceOrderPlatform.services.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("cart")
public class CartController {

    CartService cartService;

    @Autowired
    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @PostMapping("add")
    public Long addCart(@RequestParam(required = false) Long customerId) {
        return cartService.createCart(customerId);
    }

    @GetMapping("getAll")
    public List<Cart> getAllCarts() {
        return cartService.getAllCarts();
    }

    @GetMapping("getById")
    public Cart getById(@RequestParam Long id) {
        return cartService.getById(id);
    }

    @PutMapping("update")
    public Cart updateCart(@RequestParam Long id, @RequestParam(required = false) Long customerId) {
        return cartService.updateCart(id, customerId);
    }

    @DeleteMapping("delete")
    public Boolean deleteCart(@RequestParam Long id) {
        return cartService.deleteById(id);
    }
}
