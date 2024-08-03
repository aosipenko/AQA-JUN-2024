package org.prog.collections;

import org.prog.Car;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapsPractice {

    //TODO: paint all cars that dont have any color
    public static void main(String[] args) {
        Map<String, Set<Car>> ownedCars = new HashMap<>();
        String owner1 = "John";
        String owner2 = "Jane";
        String owner3 = "Peter";
        Car car = new Car();
        car.setColor("Red");

        ownedCars.put(owner1, new HashSet<>());
        ownedCars.put(owner2, new HashSet<>());
        ownedCars.put(owner3, new HashSet<>());
        ownedCars.get(owner1).add(car);
        ownedCars.get(owner1).add(new Car());
        ownedCars.get(owner2).add(car);
        ownedCars.get(owner2).add(new Car());
        ownedCars.get(owner3).add(car);
        ownedCars.get(owner3).add(new Car());
        System.out.println(ownedCars.get(owner1).size());
        //TODO: HW4 starts here
        paintCarsWithoutColor(ownedCars, "Red");
    }

    public static void paintCarsWithoutColor(Map<String, Set<Car>> ownedCars, String defaultColor) {
        for (Set<Car> cars : ownedCars.values()) {
            for (Car car : cars) {
                if (car.getColor() == null || car.getColor().isEmpty()) {
                    car.setColor(defaultColor);
                }
            }
        }
    }
}
