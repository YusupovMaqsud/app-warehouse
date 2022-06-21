package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/measurement")
public class MeasurementController {
    @Autowired
    MeasurementService measurementService;

    @PostMapping("/addmeasurement")
    public Result addMeasurementController(@RequestBody Measurement measurement) {
        Result result = measurementService.addMeasurementService(measurement);
        return result;
    }


    @GetMapping("/getmeasurement")
    public List<Measurement> getMeasurements(List<Measurement> measurements) {
        List<Measurement> measurementList = measurementService.getMeasurements(measurements);
        return measurementList;
    }

    @GetMapping("/getmeasurement/{id}")
    public Result getMeasurement(@PathVariable Integer id) {
        Result measurement = measurementService.getMeasurement(id);
        return measurement;
    }

    @DeleteMapping("/deletemeasurement/{id}")
    public Result deleteMeasurement(@PathVariable Integer id) {
        Result result = measurementService.deleteMeasurement(id);
        return result;
    }


    @PutMapping("/editmeasurement/{id}")
    public Result editMeasurement(@RequestBody Measurement measurement, Integer id) {
        Result result = measurementService.editMeasurement(measurement, id);
        return result;
    }

}
