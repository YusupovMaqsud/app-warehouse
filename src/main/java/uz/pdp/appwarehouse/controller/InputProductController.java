package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.InputProduct;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.payload.InputProductDto;
import uz.pdp.appwarehouse.payload.ProductDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.InputProductService;
import uz.pdp.appwarehouse.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/inputproduct")
public class InputProductController {
    @Autowired
    InputProductService inputProductService;

    @PostMapping("addinputproduct")
    public Result addInputProduct(@RequestBody InputProductDto inputProductDto){
        Result result = inputProductService.addInputProduct(inputProductDto);
        return result;
    }



    @GetMapping("/getinputproducts")
    public List<InputProduct> getInputProducts(){
        List<InputProduct> inputProductList = inputProductService.getInputProducts();
        return inputProductList;
    }



    @GetMapping("/getinputproduct/{id}")
    public Result getInputProduct(@PathVariable Integer id){
        Result inputProduct = inputProductService.getInputProduct(id);
        return inputProduct;
    }



    @DeleteMapping("/deleteinputproduct/{id}")
    public Result deleteInputProduct(@PathVariable Integer id){
        Result result = inputProductService.deleteInputProduct(id);
        return result;
    }



    @PutMapping("/editinputproduct/{id}")
    public Result editInputProduct(@RequestBody InputProductDto inputProductDto, Integer id){
        Result result = inputProductService.editInputProduct(inputProductDto, id);
        return result;
    }
}
