package org.prog.collections;

import org.prog.Car;

import java.util.ArrayList;

public class ListHomeWork {

    //TODO: HW3
    //TODO: - Write ArrayList which you will fill with 10 different cars
    //TODO: - Paint each 2nd car in black, others in white
    //TODO: - each car must go its index * 10 + 10 km [0*10 + 10 = 0; 1*10 + 10 = 20]
    //TODO: - print color and milage for each car after this "race"

    public static void main(String[] args) {

        ArrayList<Car> cars = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String color = (i % 2 == 1) ? "black" : "white";
            Car car = new Car(color);

            int distance = i * 10 + 10;
            car.goTo(distance);

            cars.add(car);
        }

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            System.out.println("Car " + (i + 1) + ": Color = " + car.getColor() + ", Milage = " + car.getMilage() + " km");
        }
    }
}


