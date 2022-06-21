package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.CategoryDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.CategoryService;
import uz.pdp.appwarehouse.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @PostMapping("/addcategory")
    public Result addCategoryController(@RequestBody CategoryDto categoryDto) {
        Result result = categoryService.addCategoryService(categoryDto);
        return result;
    }


    @GetMapping("/getcategory")
    public List<Category> getCategorys(List<Category> categories) {
        List<Category> categoryList = categoryService.getCategorys(categories);
        return categoryList;
    }


    @GetMapping("/getcategory/{id}")
    public Result getCategory(@PathVariable Integer id) {
        Result category = categoryService.getCategory(id);
        return category;
    }


    @DeleteMapping("/deletecategory/{id}")
    public Result deleteCategory(@PathVariable Integer id) {
        Result result = categoryService.deleteCategory(id);
        return result;
    }


    @PutMapping("/editcategory/{id}")
    public Result editCategory(@RequestBody CategoryDto categoryDto, Integer id) {
        Result result = categoryService.editCategory(categoryDto, id);
        return result;
    }
}
