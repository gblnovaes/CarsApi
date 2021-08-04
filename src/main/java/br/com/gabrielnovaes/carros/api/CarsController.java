package br.com.gabrielnovaes.carros.api;

import br.com.gabrielnovaes.carros.domain.Cars;
import br.com.gabrielnovaes.carros.domain.CarsServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cars")
public class CarsController {
    @Autowired
    private CarsServices services;

    @GetMapping()
    public Iterable<Cars>  get(){
        return services.getAllCars();
    }

}
