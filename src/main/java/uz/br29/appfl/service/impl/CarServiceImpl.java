package uz.br29.appfl.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.br29.appfl.dto.request.CarAddReq;
import uz.br29.appfl.dto.request.CarEditReq;
import uz.br29.appfl.entity.Car;
import uz.br29.appfl.repository.CarRepo;
import uz.br29.appfl.service.CarService;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CarServiceImpl implements CarService {

    private final CarRepo carRepo;

    @Override
    public ResponseEntity addCar(CarAddReq req) {
        Car car = Car.builder()
                .name(req.getName())
                .model(req.getModel())
                .year(req.getYear())
                .build();
        Car save = carRepo.save(car);
        return ResponseEntity.ok(save);
    }

    @Override
    public ResponseEntity editCar(CarEditReq req) {

        Optional<Car> optional = carRepo.findById(req.getId());
        if (optional.isEmpty()) {
            return ResponseEntity.status(404).body("Car not found");
        }

        Car car = optional.get();
        car.setYear(req.getYear());
        car.setName(req.getName());
        car.setModel(req.getModel());

        Car edit = carRepo.save(car);

        return ResponseEntity.ok(edit);

    }

    @Override
    public ResponseEntity deleteCar(long id) {
        try {
            carRepo.deleteById(id);
            return ResponseEntity.ok("Car deleted");
        }catch (Exception exception) {
            return ResponseEntity.status(409).body(exception.getMessage());
        }
    }

    @Override
    public ResponseEntity getCar(long id) {
        Optional<Car> optional = carRepo.findById(id);
        if (optional.isEmpty()) {
            return ResponseEntity.status(404).body("Car not found");
        }
        return ResponseEntity.ok(optional.get());
    }

    @Override
    public ResponseEntity getCarList() {
        return ResponseEntity.ok(carRepo.findAll().stream().toList());
    }


}
