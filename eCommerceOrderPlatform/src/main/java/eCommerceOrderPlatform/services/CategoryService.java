package eCommerceOrderPlatform.services;

import eCommerceOrderPlatform.entities.Category;
import eCommerceOrderPlatform.entities.Store;
import eCommerceOrderPlatform.repositories.CategoryRepository;
import eCommerceOrderPlatform.repositories.StoreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CategoryService {

    CategoryRepository categoryRepository;
    StoreRepository storeRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, StoreRepository storeRepository) {
        this.categoryRepository = categoryRepository;
        this.storeRepository = storeRepository;
    }

    // create
    public Long createCategory(String name, String description, Long storeId) {
        Category category = new Category();
        category.setName(name);
        category.setDescription(description);
        category.setStore(resolveStore(storeId));
        category = categoryRepository.save(category);
        return category.getId();
    }

    // get all
    public List<Category> getAllCategories() {
        return categoryRepository.getAllCategories();
    }

    // get by id
    public Category getById(Long id) {
        Category category = categoryRepository.getCategoryById(id);
        if (category == null) return new Category();
        return category;
    }

    // update
    public Category updateCategory(Long id, String name, String description, Long storeId) {
        Category category = categoryRepository.getCategoryById(id);
        if (category == null) return new Category();
        category.setName(name);
        category.setDescription(description);
        category.setStore(resolveStore(storeId));
        return categoryRepository.save(category);
    }

    // delete
    public Boolean deleteById(Long id) {
        Category category = categoryRepository.getCategoryById(id);
        if (category == null) return false;
        category.setIsActive(false);
        category.setUpdatedDate(new Date());
        categoryRepository.save(category);
        return true;
    }

    private Store resolveStore(Long storeId) {
        if (storeId == null) return null;
        return storeRepository.getStoreById(storeId);
    }
}
