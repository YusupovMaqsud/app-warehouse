package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Currency;
import uz.pdp.appwarehouse.entity.Warehouse;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.CurrencyRepository;
import uz.pdp.appwarehouse.repository.WarehouseRepository;

import java.util.List;
import java.util.Optional;

@Service
public class WarehouseService {
    @Autowired
    WarehouseRepository warehouseRepository;

    public Result addWarehouse(Warehouse warehouse) {
        boolean exists = warehouseRepository.existsByName(warehouse.getName());
        if (exists)
            return new Result("Bunday Ombor mavjud", false);

        warehouseRepository.save(warehouse);
        return new Result("Muvaffaqiyatli saqlandi", true);
    }


    public List<Warehouse> getWarehouses(List<Warehouse> warehouses) {
        List<Warehouse> warehouseList = warehouseRepository.findAll();
        return warehouseList;
    }


    public Result getWarehouse(Integer id) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (!optionalWarehouse.isPresent())
            return new Result("Ombor mavjud emas", false);

        Warehouse warehouse = optionalWarehouse.get();
        return new Result("Ombor mavjud", true, warehouse);
    }


    public Result deleteWarehouse(Integer id) {
        warehouseRepository.deleteById(id);
        return new Result("Ombor deleted", true);
    }


    public Result editWarehouse(Warehouse warehouses, Integer id) {
        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(id);
        if (!optionalWarehouse.isPresent())
            return new Result("Ombor mavjud emas", false);
        Warehouse warehouse = optionalWarehouse.get();
        warehouse.setName(warehouses.getName());
        warehouseRepository.save(warehouse);
        return new Result("Ombor edited", true);
    }
}
