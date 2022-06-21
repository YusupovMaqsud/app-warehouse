package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uz.pdp.appwarehouse.entity.Currency;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.CurrencyRepository;
import uz.pdp.appwarehouse.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class CurrencyService {
    @Autowired
    CurrencyRepository currencyRepository;
    public Result addCurrency(Currency currency) {
        boolean exists = currencyRepository.existsByName(currency.getName());
        if (exists)
            return new Result("Bunday currency mavjud", false);

       currencyRepository.save(currency);
        return new Result("Muvaffaqiyatli saqlandi", true);
    }


    public List<Currency> getCurrencys(List<Currency> currencies) {
        List<Currency> currencyList = currencyRepository.findAll();
        return currencyList;
    }


    public Result getCurrency(Integer id) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent())
            return new Result("Currency mavjud emas", false);

        Currency currency = optionalCurrency.get();
        return new Result("Currency mavjud", true, currency);
    }


    public Result deleteCurrency(Integer id) {
        currencyRepository.deleteById(id);
        return new Result("Currency deleted", true);
    }


    public Result editCurrency(Currency currencys, Integer id) {
        Optional<Currency> optionalCurrency = currencyRepository.findById(id);
        if (!optionalCurrency.isPresent())
            return new Result("Currency mavjud emas", false);
        Currency currency = optionalCurrency.get();
        currency.setName(currencys.getName());
        currencyRepository.save(currency);
        return new Result("Currency edited", true);
    }
}
