package eCommerceOrderPlatform.controllers;

import eCommerceOrderPlatform.entities.Category;
import eCommerceOrderPlatform.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("category")
public class CategoryController {

    CategoryService categoryService;

    @Autowired
    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @PostMapping("add")
    public Long addCategory(
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam(required = false) Long storeId) {

        return categoryService.createCategory(name, description, storeId);
    }

    @GetMapping("getAll")
    public List<Category> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("getById")
    public Category getById(@RequestParam Long id) {
        return categoryService.getById(id);
    }

    @PutMapping("update")
    public Category updateCategory(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String description,
            @RequestParam(required = false) Long storeId) {

        return categoryService.updateCategory(id, name, description, storeId);
    }

    @DeleteMapping("delete")
    public Boolean deleteCategory(@RequestParam Long id) {
        return categoryService.deleteById(id);
    }
}
