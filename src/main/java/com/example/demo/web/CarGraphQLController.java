package com.example.demo.web;

import com.example.demo.dao.Car;
import com.example.demo.dto.CarDTO;
import com.example.demo.service.CarService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CarGraphQLController {

    private final CarService carService;

    public CarGraphQLController(CarService carService) {
        this.carService = carService;
    }

    @QueryMapping
    public List<CarDTO> getCarByModel(@Argument String model) {
        return carService.getCarByModel(model);
    }

    @MutationMapping
    public CarDTO saveCar(@Argument CarDTO car) {
        return carService.saveCar(car);
    }

    @QueryMapping
    public List<CarDTO> getAllCars() {
        return carService.getAllCars();
    }
}
