package br.com.gabrielnovaes.cars.api;

import br.com.gabrielnovaes.cars.domain.Cars;
import br.com.gabrielnovaes.cars.domain.CarsServices;
import br.com.gabrielnovaes.cars.dto.CarsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/cars")
public class CarsController {
    @Autowired
    private CarsServices services;

    @GetMapping()
    public ResponseEntity<List<CarsDTO>> get() {
        return ResponseEntity.ok(services.getAllCars());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CarsDTO> getCarById(@PathVariable Long id) {
        Optional<CarsDTO> car = services.getCarById(id);
        if (car.isPresent()) {
            return ResponseEntity.ok(car.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/type/{type}")
    public ResponseEntity getCarByType(@PathVariable String type) {
        List<CarsDTO> cars = services.getCarByType(type);
        return cars.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(cars);
    }

    @PostMapping
    public ResponseEntity post(@RequestBody Cars car) {
        try {
            CarsDTO cars = services.save(car);
            URI location = getUrl(car.getId());

            return ResponseEntity.created(location).build();
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    private URI getUrl(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(id).toUri();
    }

    @PutMapping("/{id}")
    public ResponseEntity put(@PathVariable("id") Long id, @RequestBody Cars car) {
        car.setId(id);

        CarsDTO cars = services.update(car, id);
        return cars != null ? ResponseEntity.ok(car) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        boolean ok = services.delete(id);
        return ok ? ResponseEntity.ok().build() :
                ResponseEntity.notFound().build();
    }
}
