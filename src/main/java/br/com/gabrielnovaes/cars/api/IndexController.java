package br.com.gabrielnovaes.cars.api;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class IndexController {
    @GetMapping()
    public String get() {
        return "API  to Cars";
    }
}
