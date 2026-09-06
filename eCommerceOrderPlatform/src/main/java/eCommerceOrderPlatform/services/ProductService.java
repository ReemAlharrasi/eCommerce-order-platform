package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Product;
import eCommerceOrderPlatform.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    // create
    public Long createProduct(String name, Double price, Integer stockQuantity, String sku) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);
        product.setSku(sku);
        product = productRepository.save(product);
        return product.getId();
    }

    // get all
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    // get by id
    public Product getById(Long id) {
        Product product = productRepository.getProductById(id);
        if (product == null) return new Product();
        return product;
    }

    // update
    public Product updateProduct(Long id, String name, Double price, Integer stockQuantity, String sku) {
        Product product = productRepository.getProductById(id);
        if (product == null) return new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);
        product.setSku(sku);
        product = productRepository.save(product);
        return product;
    }

    // delete
    public Boolean deleteById(Long id) {
        Product product = productRepository.getProductById(id);
        if (product == null) return false;
        product.setIsActive(false);
        product.setUpdatedDate(new Date());
        productRepository.save(product);
        return true;
    }

}
