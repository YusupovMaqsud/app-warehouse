package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import uz.pdp.appwarehouse.entity.*;
import uz.pdp.appwarehouse.payload.InputDto;
import uz.pdp.appwarehouse.payload.OutputDto;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class OutputService {
    @Autowired
    OutputRepository outputRepository;
    @Autowired
    WarehouseRepository warehouseRepository;
    @Autowired
    ClientRepository clientRepository;
    @Autowired
    CurrencyRepository currencyRepository;

    public Result addOutput(OutputDto outputDto) {
        boolean existsByCode = outputRepository.existsByCode(outputDto.getCode());
        if(existsByCode)
            return new Result("Bunday chiqimli code mavjud", false);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarhouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("Bunday Ombor mavjud emas", false);

        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClienId());
        if (!optionalClient.isPresent())
            return new Result("Bunday Client mavjud emas", false);


        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
        if (!optionalCurrency.isPresent())
            return new Result("Bunday Currency mavjud emas", false);

        Output output = new Output();
        output.setData(outputDto.getData());
        output.setFactureNumber(outputDto.getFactureNumber());
        output.setCode(UUID.randomUUID().toString());
        output.setWarehouse(optionalWarehouse.get());
        output.setClient(optionalClient.get());
        output.setCurrency(optionalCurrency.get());
        outputRepository.save(output);

        return new Result("Chiqim saqlandi", true);
    }






    public List<Output> getOutputs() {
        List<Output> outputList = outputRepository.findAll();
        return outputList;
    }




    public Result getOutput(@PathVariable Integer id) {
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (!optionalOutput.isPresent())
            return new Result("Bunday chiqim mavjud emas", false);
        Output output = optionalOutput.get();
        return new Result("Bunday product mavjud ", true, output);
    }






    public Result deleteOutput(Integer id) {
        outputRepository.deleteById(id);
        return new Result("Chiqim deleted ", true);
    }






    public Result editOutput(OutputDto outputDto, Integer id) {
        Optional<Output> optionalOutput = outputRepository.findById(id);
        if (!optionalOutput.isPresent())
            return new Result("Bunday chiqim mavjud emas", false);

        Optional<Warehouse> optionalWarehouse = warehouseRepository.findById(outputDto.getWarhouseId());
        if (!optionalWarehouse.isPresent())
            return new Result("Bunday Ombor mavjud emas", false);

        Optional<Client> optionalClient = clientRepository.findById(outputDto.getClienId());
        if (!optionalClient.isPresent())
            return new Result("Bunday Client mavjud emas", false);


        Optional<Currency> optionalCurrency = currencyRepository.findById(outputDto.getCurrencyId());
        if (!optionalCurrency.isPresent())
            return new Result("Bunday Currency mavjud emas", false);

        Output output = optionalOutput.get();
        output.setData(outputDto.getData());
        output.setFactureNumber(outputDto.getFactureNumber());
        output.setCode(UUID.randomUUID().toString());
        output.setWarehouse(optionalWarehouse.get());
        output.setClient(optionalClient.get());
        output.setCurrency(optionalCurrency.get());
        outputRepository.save(output);

        return new Result("Chiqim edited", true);

    }
}
