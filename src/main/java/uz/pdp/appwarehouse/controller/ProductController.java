package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Category;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.payload.CategoryDto;
import uz.pdp.appwarehouse.payload.ProductDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.CategoryService;
import uz.pdp.appwarehouse.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @PostMapping("addproduct")
    public Result addProduct(@RequestBody ProductDto productDto){
        Result result = productService.addProduct(productDto);
        return result;
    }



    @GetMapping("/getproduct")
    public List<Product> getProducts(){
        List<Product> products = productService.getProducts();
        return products;
    }



    @GetMapping("/getproduct/{id}")
    public Result getProduct(@PathVariable Integer id){
        Result product = productService.getProduct(id);
        return product;
    }



    @DeleteMapping("/deleteproduct/{id}")
    public Result deleteProduct(@PathVariable Integer id){
        Result result = productService.deleteProduct(id);
        return result;
    }



    @PutMapping("/editproduct/{id}")
    public Result editProduct(@RequestBody ProductDto productDto, Integer id){
        Result result = productService.editProduct(productDto, id);
        return result;
    }
}
