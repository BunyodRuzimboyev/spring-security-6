package uz.br29.appfl.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.br29.appfl.entity.Car;

@Repository
public interface CarRepo extends JpaRepository<Car, Long> {
}
