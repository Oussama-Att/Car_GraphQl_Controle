package com.example.demo;

import com.example.demo.dao.Car;
import com.example.demo.repositories.CarRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class DemoApplication {

    private CarRepository carRepository;

    public DemoApplication(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner start(){
        return args -> {
            List<Car> cars = List.of(
                    Car.builder()
                            .price(50000.0)
                            .model("Dacia 2010")
                            .matricul("1df15")
                            .color("red")
                            .build(),
                    Car.builder()
                            .price(30000.0)
                            .model("Toyota 2002")
                            .matricul("1dsf15")
                            .color("black")
                            .build(),
                    Car.builder()
                            .price(300000.0)
                            .model("208 2019")
                            .matricul("1dqf15")
                            .color("white")
                            .build()
          );
            carRepository.saveAll(cars);
        };


    }
}
