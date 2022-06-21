package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Input;
import uz.pdp.appwarehouse.entity.Output;
import uz.pdp.appwarehouse.payload.InputDto;
import uz.pdp.appwarehouse.payload.OutputDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.InputService;
import uz.pdp.appwarehouse.service.OutputService;

import java.util.List;

@RestController
@RequestMapping("/output")
public class OutputController {
    @Autowired
    OutputService outputService;

    @PostMapping("addoutput")
    public Result addOutput(@RequestBody OutputDto outputDto){
        Result result = outputService.addOutput(outputDto);
        return result;
    }



    @GetMapping("/getoutputs")
    public List<Output> getOutputs(){
        List<Output> outputList = outputService.getOutputs();
        return outputList;
    }



    @GetMapping("/getoutput/{id}")
    public Result getOutput(@PathVariable Integer id){
        Result output = outputService.getOutput(id);
        return output;
    }



    @DeleteMapping("/deleteoutput/{id}")
    public Result deleteOutput(@PathVariable Integer id){
        Result result = outputService.deleteOutput(id);
        return result;
    }



    @PutMapping("/editoutput/{id}")
    public Result editOutput(@RequestBody OutputDto outputDto, Integer id){
        Result result = outputService.editOutput(outputDto, id);
        return result;
    }
}
