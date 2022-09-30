package ru.sber.mironov;

import java.util.*;

import static java.util.stream.Collectors.toList;

public interface Garage {
    HashMap<Owner, ArrayList<Car>> mapOwnerToCars = new HashMap<>();
    HashMap<Car, Owner> mapCarToOwner = new HashMap<>();
    HashMap<String, ArrayList<Car>> mapBrandToCar = new HashMap<>();
    HashMap<Long, Car> cars = new HashMap<>();
    HashMap<Long, Owner> owners = new HashMap<>();

    default Collection<Owner> allCarsUniqueOwners() {
        return mapOwnerToCars.keySet().stream()
                .filter(o -> mapOwnerToCars.get(o).size() == 1)
                .distinct()
                .collect(toList());
    }

    /**
     * Complexity should be less than O(n)
     */
    default Collection<Car> topThreeCarsByMaxVelocity() {
        ArrayList<Car> sorted = new ArrayList<>();
        for (Car car : cars.values()) {
            sorted.add(car);
            sorted.sort(Comparator.comparingInt(Car::getMaxVelocity));
            if (sorted.size() > 3) {
                sorted.remove(0);
            }
        }
        return sorted;
    }

    /**
     * Complexity should be O(1)
     */
    default Collection<Car> allCarsOfBrand(String brand) {
        return mapBrandToCar.get(brand);
    }

    /**
     * Complexity should be less than O(n)
     */
    default Collection<Car> carsWithPowerMoreThan(int power) {
        return mapOwnerToCars.values().stream()
                .flatMap(Collection::stream)
                .filter(car -> car.getPower() >= power)
                .distinct()
                .collect(toList());

    }

    /**
     * Complexity should be O(1)
     */
    default Collection<Car> allCarsOfOwner(Owner owner) {
        return mapOwnerToCars.get(owner);
    }

    /**
     * @return mean value of owner age that has cars with given brand
     */
    default int meanOwnersAgeOfCarBrand(String brand) {
        return (int) mapBrandToCar.get(brand).stream()
                .map(mapCarToOwner::get)
                .mapToInt(Owner::getAge)
                .average().getAsDouble();
    }

    /**
     * @return mean value of cars for all owners
     */
    default int meanCarNumberForEachOwner() {
        return (int) mapOwnerToCars.keySet().stream()
                .mapToInt(owner -> mapOwnerToCars.get(owner).size())
                .average().getAsDouble();
    }

    /**
     * Complexity should be less than O(n)
     *
     * @return removed car
     */
    default Car removeCar(int carId) {
        Car deleteCar = cars.get((long) carId);
        Owner deleteOwner = owners.get((long) deleteCar.getOwnerId());

        mapOwnerToCars.get(deleteOwner).remove(deleteCar);
        if (mapOwnerToCars.get(deleteOwner).isEmpty()) {
            mapOwnerToCars.remove(deleteOwner);
            owners.remove(deleteOwner.getOwnerId());
        }

        mapBrandToCar.get(deleteCar.getBrand()).remove(deleteCar);
        if (mapBrandToCar.get(deleteCar.getBrand()).isEmpty()) {
            mapBrandToCar.remove(deleteCar.getBrand());
        }

        mapCarToOwner.remove(deleteCar);


        cars.remove((long)carId);
        return deleteCar;
    }

    /**
     * Complexity should be less than O(n)
     */
    default void addCar(Car car, Owner owner) {

        put(mapOwnerToCars, owner, car);
        put(mapBrandToCar, car.getBrand(), car);

        mapCarToOwner.put(car, owner);
        cars.put(car.getCarId(), car);
        owners.put(owner.getOwnerId(), owner);
    }

    private <K, V> void put(HashMap<K, ArrayList<V>> collectionHashMap, K key, V value) {
        if (collectionHashMap.containsKey(key)) {
            collectionHashMap.get(key).add(value);
        } else {
            collectionHashMap.put(key, new ArrayList<>(Collections.singletonList(value)));
        }
    }
}
