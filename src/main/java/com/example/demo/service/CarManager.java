package com.example.demo.service;

import com.example.demo.dao.Car;
import com.example.demo.dto.CarDTO;
import com.example.demo.mapper.CarMapper;
import com.example.demo.repositories.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarManager implements CarService{

    private final CarRepository carRepository;
    private final CarMapper carMapper;

    public CarManager(CarRepository carRepository, CarMapper carMapper) {
        this.carRepository = carRepository;
        this.carMapper = carMapper;
    }


    @Override
    public List<CarDTO> getCarByModel(String model) {
        List<Car> cars = carRepository.findByModel(model);
        return cars.stream().map(carMapper::toCarDTO).collect(Collectors.toList());
    }

    @Override
    public CarDTO saveCar(CarDTO carDTO) {
        Car car = carMapper.toCarEntity(carDTO);
        Car savedCar = carRepository.save(car);
        return carMapper.toCarDTO(savedCar);
    }

    @Override
    public List<CarDTO> getAllCars() {
        List<Car> cars = carRepository.findAll();
        return cars.stream().map(carMapper::toCarDTO).collect(Collectors.toList());
    }


}
