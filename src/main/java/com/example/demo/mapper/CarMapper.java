package com.example.demo.mapper;

import com.example.demo.dao.Car;
import com.example.demo.dto.CarDTO;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {
    private final ModelMapper modelMapper= new ModelMapper();

    public CarDTO toCarDTO(Car car) {
        return modelMapper.map(car, CarDTO.class);
    }

    public Car toCarEntity(CarDTO carDTO) {
        return modelMapper.map(carDTO, Car.class);
    }

}
