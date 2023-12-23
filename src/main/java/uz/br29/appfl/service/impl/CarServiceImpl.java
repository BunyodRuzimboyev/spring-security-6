package uz.br29.appfl.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import uz.br29.appfl.dto.request.CarAddReq;
import uz.br29.appfl.dto.request.CarEditReq;
import uz.br29.appfl.entity.Car;
import uz.br29.appfl.exception.CarNotFoundException;
import uz.br29.appfl.repository.CarRepo;
import uz.br29.appfl.service.CarService;

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

        Optional<Car> optionalCar = Optional.ofNullable(carRepo.findById(req.getId()).orElseThrow(() -> new CarNotFoundException("Car not found")));

        Car car = optionalCar.get();

        if (req.getName() != null) car.setName(req.getName());

        if (req.getModel() != null) car.setModel(req.getModel());

        if (req.getYear() >= 1900 && req.getYear() <= 2200) car.setYear(req.getYear());


        Car edit = carRepo.save(car);
        return ResponseEntity.ok(edit);

    }

    @Override
    public ResponseEntity deleteCar(long id) {

        try {
            carRepo.deleteById(id);
            return ResponseEntity.ok("Car deleted");
        } catch (CarNotFoundException exception) {
            throw new CarNotFoundException("Car not found!");
        }
    }

    @Override
    public ResponseEntity getCar(long id) {

        Optional<Car> car = Optional.ofNullable(carRepo.findById(id).orElseThrow(() -> new CarNotFoundException("Car not found")));
        return ResponseEntity.ok(car);

//        Optional<Car> optional = carRepo.findById(id);
//        if (optional.isEmpty()) {
//            return ResponseEntity.status(404).body("Car not found");
//        }
//        return ResponseEntity.ok(optional.get());
    }

    @Override
    public ResponseEntity getCarList() {
        return ResponseEntity.ok(carRepo.findAll().stream().toList());
    }


}
