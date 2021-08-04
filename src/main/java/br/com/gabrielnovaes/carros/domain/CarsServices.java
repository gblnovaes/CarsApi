package br.com.gabrielnovaes.carros.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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

    public Iterable<Cars>  getAllCars() {
        return repository.findAll();
    }
}
