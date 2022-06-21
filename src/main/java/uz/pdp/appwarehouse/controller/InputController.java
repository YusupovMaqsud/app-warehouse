package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Input;
import uz.pdp.appwarehouse.entity.Product;
import uz.pdp.appwarehouse.payload.InputDto;
import uz.pdp.appwarehouse.payload.ProductDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.InputService;
import uz.pdp.appwarehouse.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/input")
public class InputController {
    @Autowired
    InputService inputService;

    @PostMapping("addinput")
    public Result addInput(@RequestBody InputDto inputDto){
        Result result = inputService.addInput(inputDto);
        return result;
    }



    @GetMapping("/getinputs")
    public List<Input> getInputs(){
        List<Input> inputList = inputService.getInputs();
        return inputList;
    }



    @GetMapping("/getinput/{id}")
    public Result getInput(@PathVariable Integer id){
        Result input = inputService.getInput(id);
        return input;
    }



    @DeleteMapping("/deleteinput/{id}")
    public Result deleteInput(@PathVariable Integer id){
        Result result = inputService.deleteInput(id);
        return result;
    }



    @PutMapping("/editInput/{id}")
    public Result editInput(@RequestBody InputDto inputDto, Integer id){
        Result result = inputService.editInput(inputDto, id);
        return result;
    }
}
