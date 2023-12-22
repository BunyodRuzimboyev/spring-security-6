package uz.br29.appfl.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import uz.br29.appfl.dto.request.CarAddReq;
import uz.br29.appfl.dto.request.CarEditReq;
import uz.br29.appfl.service.CarService;

@RestController
@RequestMapping("/api/v1/car")
@RequiredArgsConstructor
public class CarController {

    private final CarService carService;

    @PostMapping
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity addCar(@RequestBody CarAddReq req){
        return carService.addCar(req);
    }

    @PutMapping
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity editCar(@RequestBody CarEditReq req){
        return carService.editCar(req);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity deleteCar(@PathVariable long id){
        return carService.deleteCar(id);
    }

    @GetMapping("/{id}")
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity getCar(@PathVariable long id){
        return carService.getCar(id);
    }

    @GetMapping
    @PreAuthorize(value = "hasAnyRole('ROLE_ADMIN')")
    public ResponseEntity getCarList(){
        return carService.getCarList();
    }


}
