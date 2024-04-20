package com.apirests2.backends2.controllers;

import org.springframework.web.bind.annotation.RestController;
import com.apirests2.backends2.models.Car;
import com.apirests2.backends2.repository.CarRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("api/Car")

public class CarController {
    
    @Autowired
    private CarRepository carrepository;

    //obtener todos los carros
    @GetMapping()
    public List<Car> getAll(){
        return carrepository.findAll();
    }
    //obtener por una Id
    @GetMapping("/{id}")
    public Car getById(@PathVariable("id") Long id){
        return carrepository.findById(id).orElse(null);
    }
    //crear un carro
    @PostMapping()
    public Car CreateCar(@RequestBody Car car){
        return carrepository.save(car);
    }
    //Actualizar carros
    @PutMapping("/{id}")
    public Car updateCar(@PathVariable("id") Long id, @RequestBody Car car) {
        car.setId(id);
        return carrepository.save(car);
    }
    //Borrar carros
    @DeleteMapping("/{id}")
    public void deleteCar(@PathVariable("id") Long id){
        carrepository.deleteById(id);
    }
}
