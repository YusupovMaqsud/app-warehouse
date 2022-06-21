package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import uz.pdp.appwarehouse.entity.*;
import uz.pdp.appwarehouse.payload.InputDto;
import uz.pdp.appwarehouse.payload.ProductDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class InputService {
    @Autowired
    InputRepository inputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    public Result addInput(InputDto inputDto) {
        boolean existsByCode = inputRepository.existsByCode(inputDto.getCode());
        if(existsByCode)
        return new Result("Bunday kirimli code mavjud", false);

            Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarhouseId());
            if (!optionalWarehouse.isPresent())
                return new Result("Bunday Ombor mavjud emas", false);

            Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
            if (!optionalSupplier.isPresent())
                return new Result("Bunday Taminotchi mavjud emas", false);


            Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
            if (!optionalCurrency.isPresent())
                return new Result("Bunday Currency mavjud emas", false);

            Input input = new Input();
            input.setData(inputDto.getData());
            input.setFactureNumber(inputDto.getFactureNumber());
            input.setCode(UUID.randomUUID().toString());
            input.setWarehouse(optionalWarehouse.get());
            input.setSupplier(optionalSupplier.get());
            input.setCurrency(optionalCurrency.get());
            inputRepository.save(input);

            return new Result("Kirim saqlandi", true);

    }

    public List<Input> getInputs() {
        List<Input> inputList = inputRepository.findAll();
        return inputList;
    }


    public Result getInput(@PathVariable Integer id) {
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (!optionalInput.isPresent())
            return new Result("Bunday kirim mavjud emas", false);
        Input input = optionalInput.get();
        return new Result("Bunday product mavjud ", true, input);
    }


    public Result deleteInput(Integer id) {
        inputRepository.deleteById(id);
        return new Result("Kirim deleted ", true);
    }


    public Result editInput(InputDto inputDto, Integer id) {
        Optional<Input> optionalInput = inputRepository.findById(id);
        if (!optionalInput.isPresent())
            return new Result("Bunday kirim mavjud emas", false);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(inputDto.getWarhouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("Bunday Ombor mavjud emas", false);

        Optional<Supplier> optionalSupplier = supplierRepository.findById(inputDto.getSupplierId());
        if (!optionalSupplier.isPresent())
            return new Result("Bunday Taminotchi mavjud emas", false);


        Optional<Currency> optionalCurrency = currencyRepository.findById(inputDto.getCurrencyId());
        if (!optionalCurrency.isPresent())
            return new Result("Bunday Currency mavjud emas", false);

        Input input = optionalInput.get();
        input.setData(inputDto.getData());
        input.setFactureNumber(inputDto.getFactureNumber());
        input.setCode(UUID.randomUUID().toString());
        input.setWarehouse(optionalWarehouse.get());
        input.setSupplier(optionalSupplier.get());
        input.setCurrency(optionalCurrency.get());
        inputRepository.save(input);

        return new Result("Kirim edited", true);

    }
}
