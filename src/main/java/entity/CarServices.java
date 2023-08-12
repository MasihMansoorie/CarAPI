package entity;

import java.util.Comparator;
import java.util.Scanner;

public class CarServices {

    private static final CarDemo carDemo = new CarDemoImp(JDBConnection.getConnection());

    public static void addCar(Scanner scanner){
     //   scanner.nextLine();
        System.out.println("Enter the car brand");
        String brand = scanner.nextLine();
        System.out.println("Enter the car model");
        String model = scanner.nextLine();
        System.out.println("Enter the car color");
        String color = scanner.nextLine();
        System.out.println("Enter the car year");
        int year = scanner.nextInt();
      //  scanner.nextLine();
        System.out.println("Enter the car price");
        double price = scanner.nextDouble();

        System.out.println("Car Added Successfully");

        Car car = new Car(brand,model,color,year,price);
        carDemo.addCar(car);

    }

    public static void updateCar(Scanner scanner){

        System.out.println("Enter the car id ");
        int carId = scanner.nextInt();
        scanner.nextLine();
        Car car = carDemo.getCarById(carId);

        if(car != null) {
            carDemo.updateCar(car);

            System.out.println("Enter the car brand (Or press Enter to skip )");
            String brand = scanner.nextLine();
            System.out.println("Enter the car model (Or press Enter to skip )");
            String model = scanner.nextLine();
            System.out.println("Enter the car color (Or press Enter to skip )");
            String color = scanner.nextLine();
            System.out.println("Enter the car year (Or press Enter to 0 ) ");
            int year = scanner.nextInt();
            scanner.nextLine();
            System.out.println("Enter the car price (Or press Enter to 0 ) ");
            double price = scanner.nextDouble();
            scanner.nextLine();

            car.setBrand(brand.isEmpty() ? car.getBrand() : brand);
            car.setModel(model.isEmpty() ? car.getModel() : model);
            car.setColor(color.isEmpty() ? car.getColor() : color);
            car.setYear(year == 0 ? car.getYear() : year);
            car.setPrice(price == 0 ? car.getPrice() : price);

            carDemo.updateCar(car);
            System.out.println("Car with Id: "+ carId + "  Updated successfully");

        }else {
            System.out.println("No car found in database !");
        }
    }

    public static void deleteCar(Scanner scanner){

        System.out.println("Enter the car id ");
        int carId = scanner.nextInt();
        scanner.nextLine();
        Car car = carDemo.getCarById(carId);
        if(car != null) {
            carDemo.deleteCar(carId);
            System.out.println("Car deleted Successfully !");
        } else {
            System.out.println("No Car found to delete !");
        }
    }

    public static void getCarById(Scanner scanner) {
        System.out.println("Enter the car id to display");
        int carId = scanner.nextInt();
        scanner.nextLine();
        Car car = carDemo.getCarById(carId);
        if(car != null){
            System.out.println(car);
        }else {
            System.out.println("No Car Found in the database");
        }
    }


    public static void getAllCars(){
        if(carDemo.getAllCars().size() > 0) {
            for(Car car : carDemo.getAllCars()) {
                System.out.println(car);
            }
        }else {
            System.out.println("No Car Available");
        }
    }

    public static void getAllCarsSortedByPrice() {
        if(carDemo.getAllCars().size() > 0) {
            carDemo.getAllCars().stream()
                    .sorted(Comparator.comparing(Car::getPrice))
                    .forEach(System.out::println);
        }else {
            System.out.println("No Car Found in the database !");
        }
    }

    public static void getAllCarsSortedByYear(){
        if(!carDemo.getAllCars().isEmpty()) {
            carDemo.getAllCars().stream()
                    .sorted(Comparator.comparing(Car::getYear))
                    .forEach(System.out::println);
        }
    }

}
