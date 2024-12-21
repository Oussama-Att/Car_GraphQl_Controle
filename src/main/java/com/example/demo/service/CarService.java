package com.example.demo.service;

import com.example.demo.dto.CarDTO;

import java.util.List;

public interface CarService {
    List<CarDTO> getCarByModel(String model);
    CarDTO saveCar(CarDTO carDTO);
    List<CarDTO> getAllCars();
}
