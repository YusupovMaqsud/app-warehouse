package uz.pdp.appwarehouse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import uz.pdp.appwarehouse.entity.Currency;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.service.CurrencyService;
import uz.pdp.appwarehouse.service.MeasurementService;

import java.util.List;

@RestController
@RequestMapping("/currency")
public class CurrencyController {
    @Autowired
    CurrencyService currencyService;

    @PostMapping("/addcurrency")
    public Result addCurrency(@RequestBody Currency currency) {
        Result result = currencyService.addCurrency(currency);
        return result;
    }


    @GetMapping("/getcurrency")
    public List<Currency> getCurrencys(List<Currency> currencies) {
        List<Currency> currencyList = currencyService.getCurrencys(currencies);
        return currencyList;
    }

    @GetMapping("/getcurrency/{id}")
    public Result getCurrency(@PathVariable Integer id) {
        Result currency = currencyService.getCurrency(id);
        return currency;
    }

    @DeleteMapping("/deletecurrency/{id}")
    public Result deleteCurrency(@PathVariable Integer id) {
        Result result = currencyService.deleteCurrency(id);
        return result;
    }


    @PutMapping("/editcurrency/{id}")
    public Result editCurrency(@RequestBody Currency currency, Integer id) {
        Result result = currencyService.editCurrency(currency, id);
        return result;
    }

}
