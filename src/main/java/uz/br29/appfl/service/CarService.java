package uz.br29.appfl.service;

import org.springframework.http.ResponseEntity;
import uz.br29.appfl.dto.request.CarAddReq;
import uz.br29.appfl.dto.request.CarEditReq;

public interface CarService {
    ResponseEntity addCar(CarAddReq req);

    ResponseEntity editCar(CarEditReq req);

    ResponseEntity deleteCar(long id);

    ResponseEntity getCar(long id);

    ResponseEntity getCarList();

}
