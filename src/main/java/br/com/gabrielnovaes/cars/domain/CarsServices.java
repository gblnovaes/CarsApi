package br.com.gabrielnovaes.cars.domain;

import br.com.gabrielnovaes.cars.dto.CarsDTO;
import org.modelmapper.internal.util.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarsServices {

    @Autowired
    private CarsRepository repository;

    public List<CarsDTO> getAllCars() {
        List<Cars> cars = repository.findAll();
        return cars.stream().map(CarsDTO::create).collect(Collectors.toList());
    }

    public Optional<CarsDTO> getCarById(Long id) {
        return repository.findById(id).map(CarsDTO::create);
    }

    public List<CarsDTO> getCarByType(String type) {
        return repository.findByType(type).stream().map(CarsDTO::create).collect(Collectors.toList());
    }

    public CarsDTO  save(Cars    car) {
        Assert.isNull(car.getId(),"Not possible save new car!!");
        return CarsDTO.create(repository.save(car));
    }


    public CarsDTO  update(Cars car, Long id) {
        Assert.notNull(id,"Not possible updated car!!");

        Optional<Cars> optionalCars = repository.findById(id);
        if (optionalCars.isPresent()) {
            Cars  db = optionalCars.get();
            db.setName(car.getName());
            db.setType(car.getType());
            System.out.println("Car id: " + db.getId());
            repository.save(db);
            return CarsDTO.create(db);
        } else {
            return null;
        }
    }

    public boolean  delete(Long id) {
        if (getCarById(id).isPresent()) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
