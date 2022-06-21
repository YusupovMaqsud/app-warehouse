package uz.pdp.appwarehouse.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import uz.pdp.appwarehouse.entity.Measurement;
import uz.pdp.appwarehouse.payload.Result;
import uz.pdp.appwarehouse.repository.MeasurementRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MeasurementService {
    @Autowired
    MeasurementRepository measurementRepository;

    public Result addMeasurementService(Measurement measurement) {
        boolean exists = measurementRepository.existsByName(measurement.getName());
        if (exists)
            return new Result("Bunday o'lchov birligi mavjud", false);

        measurementRepository.save(measurement);

        return new Result("Muvaffaqiyatli saqlandi", true);
    }


    public List<Measurement> getMeasurements(List<Measurement> measurements) {
        List<Measurement> measurementList = measurementRepository.findAll();
        return measurementList;
    }


    public Result getMeasurement(Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent())
            return new Result("Mahsulot mavjud emas", false);

        Measurement measurement = optionalMeasurement.get();
        return new Result("Mahsulot mavjud", true, measurement);
    }


    public Result deleteMeasurement(Integer id) {
        measurementRepository.deleteById(id);
        return new Result("Measurement deleted", true);
    }


    public Result editMeasurement(Measurement measurements, Integer id) {
        Optional<Measurement> optionalMeasurement = measurementRepository.findById(id);
        if (!optionalMeasurement.isPresent())
            return new Result("Measurement mavjud emas", false);
        Measurement measurement = optionalMeasurement.get();
        measurement.setName(measurements.getName());
        measurementRepository.save(measurement);
        return new Result("Measurement edited", true);
    }
}
