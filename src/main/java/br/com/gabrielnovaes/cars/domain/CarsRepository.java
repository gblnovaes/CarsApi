package br.com.gabrielnovaes.cars.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarsRepository extends CrudRepository<Cars,Long> {
    List<Cars> findByType(String type);
}
