package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.InputProduct;
import uz.pdp.appwarehouse.entity.OutputProduct;
import uz.pdp.appwarehouse.payload.InputProductDto;
import uz.pdp.appwarehouse.payload.OutputProductDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.InputProductService;
import uz.pdp.appwarehouse.service.OutputProductService;

import java.util.List;

@RestController
@RequestMapping("/outputproduct")
public class OutputProductController {
    @Autowired
    OutputProductService outputProductService;

    @PostMapping("addoutputproduct")
    public Result addOutputProduct(@RequestBody OutputProductDto outputProductDto) {
        Result result = outputProductService.addOutputProduct(outputProductDto);
        return result;
    }


    @GetMapping("/getoutputproducts")
    public List<OutputProduct> getOutputProducts() {
        List<OutputProduct> outputProductList = outputProductService.getOutputProducts();
        return outputProductList;
    }


    @GetMapping("/getoutputproduct/{id}")
    public Result getOutputProduct(@PathVariable Integer id) {
        Result outputProduct = outputProductService.getOutputProduct(id);
        return outputProduct;
    }


    @DeleteMapping("/deleteoutputproduct/{id}")
    public Result deleteOutputProduct(@PathVariable Integer id) {
        Result result = outputProductService.deleteOutputProduct(id);
        return result;
    }


    @PutMapping("/editoutputproduct/{id}")
    public Result editOutputProduct(@RequestBody OutputProductDto outputProductDto, Integer id) {
        Result result = outputProductService.editOutputProduct(outputProductDto, id);
        return result;
    }
}
