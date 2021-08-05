package br.com.gabrielnovaes.cars.domain;

import org.springframework.data.repository.CrudRepository;

public interface CarsRepository extends CrudRepository<Cars,Long> {
    Iterable<Cars> findByType(String type);
}
