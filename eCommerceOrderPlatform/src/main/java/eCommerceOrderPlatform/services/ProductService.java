package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Category;
import eCommerceOrderPlatform.entities.Product;
import eCommerceOrderPlatform.entities.Store;
import eCommerceOrderPlatform.repositories.CategoryRepository;
import eCommerceOrderPlatform.repositories.ProductRepository;
import eCommerceOrderPlatform.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProductService {
    ProductRepository productRepository;
    CategoryRepository categoryRepository;
    StoreRepository storeRepository;

    @Autowired
    public ProductService(ProductRepository productRepository,
                          CategoryRepository categoryRepository,
                          StoreRepository storeRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.storeRepository = storeRepository;
    }

    // create
    public Long createProduct(String name, Double price, Integer stockQuantity, String sku,
                              Long categoryId, Long storeId) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);
        product.setSku(sku);
        product.setCategory(resolveCategory(categoryId));
        product.setStore(resolveStore(storeId));
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
    public Product updateProduct(Long id, String name, Double price, Integer stockQuantity, String sku,
                                 Long categoryId, Long storeId) {
        Product product = productRepository.getProductById(id);
        if (product == null) return new Product();
        product.setName(name);
        product.setPrice(price);
        product.setStockQuantity(stockQuantity);
        product.setSku(sku);
        product.setCategory(resolveCategory(categoryId));
        product.setStore(resolveStore(storeId));
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

    private Category resolveCategory(Long categoryId) {
        if (categoryId == null) return null;
        return categoryRepository.getCategoryById(categoryId);
    }

    private Store resolveStore(Long storeId) {
        if (storeId == null) return null;
        return storeRepository.getStoreById(storeId);
    }
}
