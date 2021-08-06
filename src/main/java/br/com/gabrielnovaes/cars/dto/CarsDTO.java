package br.com.gabrielnovaes.cars.dto;

import br.com.gabrielnovaes.cars.domain.Cars;
import lombok.Data;

@Data
public class CarsDTO {
    private Long id;
    private String name;
    private String type;

    public CarsDTO(Cars car){
            this.id = car.id;
            this.name = car.name;
            this.type = car.type;
    }
}

