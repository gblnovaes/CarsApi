package br.com.gabrielnovaes.cars.dto;

import br.com.gabrielnovaes.cars.domain.Cars;
import lombok.Data;
import org.modelmapper.ModelMapper;

@Data
public class CarsDTO {
    private Long id;
    private String name;
    private String type;

    public static CarsDTO create(Cars car) {
        ModelMapper modelMapper = new ModelMapper();
        CarsDTO carsDTO = modelMapper.map(car, CarsDTO.class);
        return carsDTO;
    }
}

