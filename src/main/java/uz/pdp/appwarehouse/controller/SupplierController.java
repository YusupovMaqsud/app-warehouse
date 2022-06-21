package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Client;
import uz.pdp.appwarehouse.entity.Supplier;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.ClientService;
import uz.pdp.appwarehouse.service.SupplierService;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService supplierService;

    @PostMapping("/addsupplier")
    public Result addSupplier(@RequestBody Supplier supplier) {
        Result result = supplierService.addSupplier(supplier);
        return result;
    }


    @GetMapping("/getsuppliers")
    public List<Supplier> getSuppliers(List<Supplier> suppliers) {
        List<Supplier> supplierList = supplierService.getSuppliers(suppliers);
        return supplierList;
    }

    @GetMapping("/getsupplier/{id}")
    public Result getSupplier(@PathVariable Integer id) {
        Result supplier = supplierService.getSupplier(id);
        return supplier;
    }


    @DeleteMapping("/deletesupplier/{id}")
    public Result deleteSupplier(@PathVariable Integer id) {
        Result result = supplierService.deleteSupplier(id);
        return result;
    }


    @PutMapping("/editsupplier/{id}")
    public Result editSupplier(@RequestBody Supplier supplier, Integer id) {
        Result result = supplierService.editSupplier(supplier, id);
        return result;
    }

}
