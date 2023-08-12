package entity;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDemoImp implements CarDemo {

    private Connection connection;

    public CarDemoImp(Connection connection){
        this.connection = connection;
    }

    @Override
    public void addCar(Car car) {

        try( PreparedStatement statement = connection.prepareStatement("INSERT INTO cars(brand,model,color,year,price)"+
                "value(?,?,?,?,?)")) {
            statement.setString(1, car.getBrand());
            statement.setString(2,car.getModel());
            statement.setString(3,car.getColor());
            statement.setInt(4,car.getYear());
            statement.setDouble(5,car.getPrice());
            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void updateCar(Car car) {

        try(PreparedStatement statement = connection.prepareStatement("UPDATE cars set brand = ?," +
                "model = ?, color = ?, year = ?, price = ? where carId = ?")){
                statement.setString(1,car.getBrand());
                statement.setString(2,car.getModel());
                statement.setString(3,car.getColor());
                statement.setInt(4,car.getYear());
                statement.setDouble(5,car.getPrice());
                statement.setInt(6,car.getId());
                statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void deleteCar(int carId) {

        try(PreparedStatement statement = connection.prepareStatement("DELETE FROM cars where carId = ?")) {
           statement.setInt(1,carId);
           statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Car getCarById(int carId) {
        Car car = null;
        try(PreparedStatement statement = connection.prepareStatement("SELECT * FROM cars where carId = ?")) {
            statement.setInt(1,carId);
            ResultSet rs = statement.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("carId");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                String color = rs.getString("color");
                int year = rs.getInt("year");
                double price = rs.getDouble("price");
                 car = new Car(id,brand,model,color,year,price);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return car;
    }

    @Override
    public List<Car> getAllCars() {

        List<Car> cars = new ArrayList<>();

        try (PreparedStatement statement = connection.prepareStatement("SELECT * FROM cars;");
                ResultSet rs = statement.executeQuery()) {

            while ((rs.next())) {
                int id = rs .getInt("carId");
                String brand = rs.getString("brand");
                String model = rs.getString("model");
                String color = rs.getString("color");
                int year = rs.getInt("year");
                double price = rs.getDouble("price");

                Car car = new Car(id,brand,model,color,year,price);
                cars.add(car);
            }

        } catch (SQLException e) {
                e.printStackTrace();
        }
        return cars;
    }

}
