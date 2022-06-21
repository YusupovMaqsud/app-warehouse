package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.CategoryDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.CategoryRepository;
import uz.pdp.appwarehouse.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {
    @Autowired
    CategoryRepository categoryRepository;


    public Result addCategoryService(CategoryDto categoryDto) {
        Category category = new Category();
        category.setName(categoryDto.getName());
        if (categoryDto.getParentCategoryId() != null) {
            Optional<Category> optionalParentCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
            if (!optionalParentCategory.isPresent())
                return new Result("Bunday Ota category mavjud emas", false);
            category.setParentCategory(optionalParentCategory.get());
        }
        categoryRepository.save(category);
        return new Result("Muffaqiyatli saqlandi", true);
    }




    public List<Category> getCategorys(List<Category> categories) {
        List<Category> categoryList = categoryRepository.findAll();
        return categoryList;
    }




    public Result getCategory(Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent())
            return new Result("Category mavjud emas", false);
        Category category = optionalCategory.get();
        return new Result("Category topildi", true, category);
    }




    public Result deleteCategory(Integer id) {
        categoryRepository.deleteById(id);
        return new Result("Category deleted", true);
    }





    public Result editCategory(CategoryDto categoryDto, Integer id) {
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if (!optionalCategory.isPresent())
            return new Result("Category mavjud emas", false);

        Optional<Category> optionalParentCategory = categoryRepository.findById(categoryDto.getParentCategoryId());
        if (!optionalParentCategory.isPresent())
            return new Result("ParentCategory mavjud emas", false);

        Category category = optionalCategory.get();
        category.setName(categoryDto.getName());
        category.setParentCategory(optionalParentCategory.get());
        categoryRepository.save(category);
        return new Result("Category edited", true);

    }

}
