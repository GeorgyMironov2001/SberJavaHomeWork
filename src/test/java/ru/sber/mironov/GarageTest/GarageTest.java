package ru.sber.mironov.GarageTest;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;
import org.junit.Assert;
import ru.sber.mironov.Car;
import ru.sber.mironov.Garage;
import ru.sber.mironov.Owner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Pair {
    final Owner owner;
    final Car car;

    Pair(Owner owner, Car car) {
        this.owner = owner;
        this.car = car;
    }
}

public class GarageTest implements Garage {
    private ArrayList<Owner> owners;
    private ArrayList<Car> cars;

    private ArrayList<Pair> pairs;


    @Before
    public void setUpOwnersAndCars() {
        Owner o0 = new Owner(6789, "Anton", "qu", 102);
        Owner o1 = new Owner(1234, "Lexa", "Pak", 37);
        Owner o2 = new Owner(4321, "Petya", "Lisicin", 42);
        Owner o3 = new Owner(1894, "Vadim", "Kamushkin", 24);
        Owner o4 = new Owner(1290, "Olga", "Miroshina", 37);
        Owner o5 = new Owner(4560, "Svetlana", "Gorkova", 40);
        Owner o6 = new Owner(4567, "Polina", "kravec", 18);

        Car c0 = new Car(111, "Renault", "duster", 170, 80, 6789);
        Car c1 = new Car(222, "Lada", "kalina", 40, 30, 6789);
        Car c2 = new Car(333, "shevrolet", "niva", 10, 5, 6789);

        Car c3 = new Car(123, "Lada", "priora", 100, 20, 1234);
        Car c4 = new Car(456, "Nissan", "suny", 221, 30, 1234);

        Car c5 = new Car(789, "skoda", "rapid", 220, 10, 4321);
        Car c6 = new Car(901, "mazda", "bongo", 100, 71, 4321);

        Car c7 = new Car(112, "Opel", "astra", 190, 50, 1894);

        Car c8 = new Car(124, "ford", "focus", 170, 50, 1290);

        Car c9 = new Car(378, "audi", "s5", 250, 100, 4560);

        Car c10 = new Car(192, "Nissan", "Tiida", 180, 60, 4567);

        pairs = new ArrayList<>();
        pairs.add(new Pair(o0, c0));
        pairs.add(new Pair(o0, c1));
        pairs.add(new Pair(o0, c2));
        pairs.add(new Pair(o1, c3));
        pairs.add(new Pair(o1, c4));
        pairs.add(new Pair(o2, c5));
        pairs.add(new Pair(o2, c6));
        pairs.add(new Pair(o3, c7));
        pairs.add(new Pair(o4, c8));
        pairs.add(new Pair(o5, c9));
        pairs.add(new Pair(o6, c10));

        owners = new ArrayList<>(Arrays.asList(o0, o1, o2, o3, o4, o5, o6));
        cars = new ArrayList<>(Arrays.asList(c0, c1, c2, c3, c4, c5, c6, c7, c8, c9, c10));


    }

    @Test
    public void addCarTest() {
        this.addCar(cars.get(0), owners.get(0));
        this.addCar(cars.get(1), owners.get(0));
        this.addCar(cars.get(2), owners.get(0));
        Assert.assertEquals(this.removeCar((int) cars.get(0).getCarId()), cars.get(0));
        Assert.assertEquals(this.removeCar((int) cars.get(1).getCarId()), cars.get(1));
        Assert.assertEquals(this.removeCar((int) cars.get(2).getCarId()), cars.get(2));
    }


    @After
    public void tearDown() {
        owners.clear();
        cars.clear();
        pairs.clear();
    }

    @Test
    public void testTestAllCarsUniqueOwners() {
        for (Pair p : pairs) {
            addCar(p.car, p.owner);
        }
        Assert.assertEquals(allCarsUniqueOwners().stream()
                        .sorted(Comparator.comparingLong(Owner::getOwnerId))
                        .collect(toList()),
                Stream.of(owners.get(3), owners.get(4), owners.get(5), owners.get(6))
                        .sorted(Comparator.comparingLong(Owner::getOwnerId))
                        .collect(toList()));
        for (Pair p : pairs) {
            Assert.assertEquals(removeCar((int) p.car.getCarId()), p.car);
        }
    }

    @Test
    public void testTestTopThreeCarsByMaxVelocity() {
        for (Pair p : pairs) {
            addCar(p.car, p.owner);
        }
        Assert.assertEquals(topThreeCarsByMaxVelocity(), List.of(cars.get(5), cars.get(4), cars.get(9)));
        for (Pair p : pairs) {
            Assert.assertEquals(removeCar((int) p.car.getCarId()), p.car);
        }
    }

    @Test
    public void testTestAllCarsOfBrand() {
        for (Pair p : pairs) {
            addCar(p.car, p.owner);
        }
        Assert.assertEquals(allCarsOfBrand("Lada").stream()
                .sorted(Comparator.comparingLong(Car::getCarId)).collect(toList()), Stream.of(cars.get(1), cars.get(3))
                .sorted(Comparator.comparingLong(Car::getCarId)).collect(toList()));
        for (Pair p : pairs) {
            Assert.assertEquals(removeCar((int) p.car.getCarId()), p.car);
        }
    }

    @Test
    public void testTestCarsWithPowerMoreThan() {
        for (Pair p : pairs) {
            addCar(p.car, p.owner);
        }
        Assert.assertEquals(carsWithPowerMoreThan(40).stream()
                .sorted(Comparator.comparingLong(Car::getCarId)).collect(toList()), Stream.of(cars.get(0), cars.get(6), cars.get(7),
                        cars.get(8), cars.get(9), cars.get(10))
                .sorted(Comparator.comparingLong(Car::getCarId)).collect(toList()));
        for (Pair p : pairs) {
            Assert.assertEquals(removeCar((int) p.car.getCarId()), p.car);
        }
    }

    @Test
    public void testTestAllCarsOfOwner() {
        for (Pair p : pairs) {
            addCar(p.car, p.owner);
        }
        Assert.assertEquals(allCarsOfOwner(owners.get(0)).stream()
                .sorted(Comparator.comparingLong(Car::getCarId)).collect(toList()), Stream.of(cars.get(0), cars.get(1), cars.get(2))
                .sorted(Comparator.comparingLong(Car::getCarId)).collect(toList()));
        for (Pair p : pairs) {
            Assert.assertEquals(removeCar((int) p.car.getCarId()), p.car);
        }
    }

    @Test
    public void testTestMeanOwnersAgeOfCarBrand() {
        for (Pair p : pairs) {
            addCar(p.car, p.owner);
        }
        Assert.assertEquals(meanOwnersAgeOfCarBrand("Nissan"), 27);
        for (Pair p : pairs) {
            Assert.assertEquals(removeCar((int) p.car.getCarId()), p.car);
        }
    }

    @Test
    public void testTestMeanCarNumberForEachOwner() {
        for (Pair p : pairs) {
            addCar(p.car, p.owner);
        }
        Assert.assertEquals(meanCarNumberForEachOwner(), 1);
        for (Pair p : pairs) {
            Assert.assertEquals(removeCar((int) p.car.getCarId()), p.car);
        }
    }


}
