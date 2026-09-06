package eCommerceOrderPlatform.controllers;

import eCommerceOrderPlatform.entities.Product;
import eCommerceOrderPlatform.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("product")
public class ProductController {

    ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("add")
    public Long addProduct(
            @RequestParam String name,
            @RequestParam Double price,
            @RequestParam Integer stockQuantity,
            @RequestParam String sku) {

        return productService.createProduct(
                name, price, stockQuantity, sku
        );
    }

    @GetMapping("getAll")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("getById")
    public Product getById(@RequestParam Long id) {
        return productService.getById(id);
    }

    @PutMapping("update")
    public Product updateProduct(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam Double price,
            @RequestParam Integer stockQuantity,
            @RequestParam String sku) {

        return productService.updateProduct(
                id, name, price, stockQuantity, sku
        );
    }

    @DeleteMapping("delete")
    public Boolean deleteProduct(@RequestParam Long id) {
        return productService.deleteById(id);
    }
}
