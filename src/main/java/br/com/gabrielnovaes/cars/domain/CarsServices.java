package br.com.gabrielnovaes.cars.domain;

import br.com.gabrielnovaes.cars.dto.CarsDTO;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarsServices {

    @Autowired
    private CarsRepository repository;

    public List<Cars> getAllCarsFake() {
        List<Cars> cars = new ArrayList<>();
        cars.add(new Cars(1L, "Chevette", ""));
        cars.add(new Cars(2L, "Honda Civic", ""));
        cars.add(new Cars(3L, "Alfa Romeo", ""));
        return cars;
    }

    public List<CarsDTO> getAllCars() {
        List<Cars> cars = repository.findAll();
        List<CarsDTO> carsListDTO = cars.stream().map(CarsDTO::create).collect(Collectors.toList());
        return carsListDTO;
    }

    public Optional<CarsDTO> getCarById(Long id) {
        return repository.findById(id).map(CarsDTO::create);
    }

    public List<CarsDTO> getCarByType(String type) {
        return repository.findByType(type).stream().map(CarsDTO::create).collect(Collectors.toList());
    }

    public CarsDTO  save(Cars    car) {
        return CarsDTO.create(repository.save(car));
    }


    public Cars  update(Cars car, Long id) {
        Optional<CarsDTO> optionalCars = getCarById(id);
        if (optionalCars.isPresent()) {
            CarsDTO db = optionalCars.get();
            db.setName(car.getName());
            db.setType(car.getType());
            System.out.println("Car id: " + db.getId());
            repository.save(car);
            return car;
        } else {
            throw new RuntimeException("Not possible update register");
        }
    }

    public void delete(Long id) {
        if (getCarById(id).isPresent()) {
            repository.deleteById(id);
        }
    }
}
