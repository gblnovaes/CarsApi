package br.com.gabrielnovaes.carros.domain;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CarsRepository extends CrudRepository<Cars,Long> {
    Iterable<Cars> findByType(String type);
}
