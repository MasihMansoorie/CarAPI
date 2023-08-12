package entity;

import java.util.List;

public interface CarDemo {

    void addCar(Car car);
    void updateCar(Car car);
    void deleteCar(int carId);
    Car getCarById(int carId);
    List<Car> getAllCars();


}
