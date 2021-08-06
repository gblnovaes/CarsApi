package br.com.gabrielnovaes.cars.api;

import br.com.gabrielnovaes.cars.domain.Cars;
import br.com.gabrielnovaes.cars.domain.CarsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cars")
public class CarsController {
    @Autowired
    private CarsServices services;

    @GetMapping()
    public ResponseEntity<Iterable<Cars>> get() {
        return ResponseEntity.ok(services.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cars> getCarById(@PathVariable Long id) {
        Optional<Cars> car = services.getCarById(id);
        if (car.isPresent()) {
            return ResponseEntity.ok(car.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/type/{type}")
    public ResponseEntity<List<Cars>> getCarByType(@PathVariable String type) {
        List<Cars> cars = services.getCarByType(type);
        return cars.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(cars);
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
    public String deleteById(@PathVariable Long id) {
        services.delete(id);
        return "Car Deleted";
    }
}
