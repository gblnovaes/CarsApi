package br.com.gabrielnovaes.cars.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CarsRepository extends JpaRepository<Cars,Long> {
    List<Cars> findByType(String type);
}
