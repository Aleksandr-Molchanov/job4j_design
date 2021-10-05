package ru.job4j.ood.srp;

public class DriveCar implements Drive {

    private final JeepCar jeepCar;

    public DriveCar(JeepCar jeepCar) {
        this.jeepCar = jeepCar;
    }

    @Override
    public void run(int size) {
    }
}
