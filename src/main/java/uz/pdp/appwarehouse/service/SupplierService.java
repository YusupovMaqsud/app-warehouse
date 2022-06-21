package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Client;
import uz.pdp.appwarehouse.entity.Supplier;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.ClientRepository;
import uz.pdp.appwarehouse.repository.SupplierRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository supplierRepository;

    public Result addSupplier(Supplier supplier) {
        boolean exists = supplierRepository.existsByName(supplier.getName());
        if (exists) {
            return new Result("Bunday client mavjud", false);
        }

        supplierRepository.save(supplier);

        return new Result("Muvaffaqiyatli saqlandi", true);
    }


    public List<Supplier> getSuppliers(List<Supplier> suppliers) {
        List<Supplier> supplierList = supplierRepository.findAll();
        return supplierList;
    }


    public Result getSupplier(Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent())
            return new Result("Taminotchi mavjud emas", false);

        Supplier supplier = optionalSupplier.get();
        return new Result("Taminotchi mavjud", true, supplier);
    }


    public Result deleteSupplier(Integer id) {
        supplierRepository.deleteById(id);
        return new Result("Taminotchi deleted", true);
    }


    public Result editSupplier(Supplier suppliers, Integer id) {
        Optional<Supplier> optionalSupplier = supplierRepository.findById(id);
        if (!optionalSupplier.isPresent())
            return new Result("Taminotchi mavjud emas", false);
        Supplier supplier = optionalSupplier.get();
        supplier.setName(suppliers.getName());
        supplier.setPhoneNumber(suppliers.getPhoneNumber());
        supplierRepository.save(supplier);
        return new Result("Taminotchi edited", true);
    }
}
