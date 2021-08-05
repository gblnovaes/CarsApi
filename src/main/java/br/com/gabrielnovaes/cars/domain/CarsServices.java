package br.com.gabrielnovaes.cars.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CarsServices {

    @Autowired
    private CarsRepository repository;

    public List<Cars> getAllCarsFake() {
        List<Cars> cars = new ArrayList<>();
        cars.add(new Cars(1L, "Chevette"));
        cars.add(new Cars(2L, "Honda Civic"));
        cars.add(new Cars(3L, "Alfa Romeo"));
        return cars;
    }

    public Iterable<Cars> getAllCars() {
        return repository.findAll();
    }

    public Optional<Cars> getCarById(Long id) {
        return repository.findById(id);
    }

    public Iterable<Cars> getCarByType(String type) {
        return repository.findByType(type);
    }

    public Cars save(Cars car) {
        return repository.save(car);
    }
}
