package ru.job4j.ood.srp;

/**
 * Здесь нарушение SRP - в конструктор нужно поместить интерфейс Сars, а не класс JeepCar
 */
public class DriveCar implements Drive {

    private final JeepCar jeepCar;

    public DriveCar(JeepCar jeepCar) {
        this.jeepCar = jeepCar;
    }

    @Override
    public void run(int size) {
    }
}
