package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Currency;
import uz.pdp.appwarehouse.entity.Warehouse;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.CurrencyService;
import uz.pdp.appwarehouse.service.WarehouseService;

import java.util.List;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
    @Autowired
    WarehouseService warehouseService;

    @PostMapping("/addwarehouse")
    public Result addWarehouse(@RequestBody Warehouse warehouse) {
        Result result = warehouseService.addWarehouse(warehouse);
        return result;
    }


    @GetMapping("/getwarehouses")
    public List<Warehouse> getWarehouses(List<Warehouse> warehouses) {
        List<Warehouse> warehouseList = warehouseService.getWarehouses(warehouses);
        return warehouseList;
    }

    @GetMapping("/getwarehouse/{id}")
    public Result getWarehouse(@PathVariable Integer id) {
        Result warehouse = warehouseService.getWarehouse(id);
        return warehouse;
    }

    @DeleteMapping("/deletecurrency/{id}")
    public Result deleteCurrency(@PathVariable Integer id) {
        Result result = warehouseService.deleteWarehouse(id);
        return result;
    }


    @PutMapping("/editwarehouse/{id}")
    public Result editWarehouse(@RequestBody Warehouse warehouse, Integer id) {
        Result result = warehouseService.editWarehouse(warehouse, id);
        return result;
    }

}
