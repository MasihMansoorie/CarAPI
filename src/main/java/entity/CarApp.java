package entity;

import java.util.Scanner;

public class CarApp {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int choice = 0;
        do {
            System.out.println("======>>> WELCOME TO CAR SHOW <<<====== ");
            System.out.println(""" 
                  Please choose from the following options : 
                    1. Add a car\s
                    2. Update a car\s
                    3. Delete a car\s
                    4. Retrieve a car\s
                    5. Show all cars\s
                    6. List of Cars Sorted by Price\s
                    7. List of Cars Sorted by Year\s
                    8. Exit the program\s""");

//                 choice = Integer.parseInt(scan.nextLine());
                    choice = scan.nextInt();
                    scan.nextLine();


            switch (choice) {
                case 1:
                    CarServices.addCar(scan);
                    break;
                case 2:
                    CarServices.updateCar(scan);
                    break;
                case 3:
                    CarServices.deleteCar(scan);
                    break;
                case 4:
                    CarServices.getCarById(scan);
                    break;
                case 5:
                    CarServices.getAllCars();
                    break;
                case 6:
                    CarServices.getAllCarsSortedByPrice();
                    break;
                case 7:
                    CarServices.getAllCarsSortedByYear();
                    break;
                case 8:
                    System.out.println("Good Bye, Thanks for working with us !");
                    //  System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice, try again");

            }
        } while (choice != 8);
        scan.close();
    }
}
