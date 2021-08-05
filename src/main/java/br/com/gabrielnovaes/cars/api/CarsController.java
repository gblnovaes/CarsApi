package br.com.gabrielnovaes.cars.api;

import br.com.gabrielnovaes.cars.domain.Cars;
import br.com.gabrielnovaes.cars.domain.CarsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cars")
public class CarsController {
    @Autowired
    private CarsServices services;

    @GetMapping()
    public Iterable<Cars> get() {
        return services.getAllCars();
    }

    @GetMapping("/{id}")
    public Optional<Cars> getCarById(@PathVariable Long id) {
        return services.getCarById(id);
    }

    @GetMapping("/type/{type}")
    public Iterable<Cars> getCarByType(@PathVariable String type) {
        return services.getCarByType(type);
    }

    @PostMapping
    public String post(@RequestBody Cars car) {
        Cars cars = services.save(car);
        return "Car Saved !!!";
    }

    @PutMapping("/{id}")
    public String put(@PathVariable Long id, @RequestBody Cars car) {
        Cars cars = services.update(car, id);
        return "Car Updated";
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable  Long id){
        services.delete( id);
        return "Car Deleted";
    }




}
