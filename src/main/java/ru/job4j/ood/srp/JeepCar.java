package ru.job4j.ood.srp;

import java.util.Objects;

public class JeepCar {

    private String model;

    private String number;

    public JeepCar(String model, String number) {
        this.model = model;
        this.number = number;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        JeepCar car = (JeepCar) o;
        return Objects.equals(model, car.model) && Objects.equals(number, car.number);
    }

    @Override
    public int hashCode() {
        return Objects.hash(model, number);
    }

    @Override
    public String toString() {
        return "Car{"
                + "model='" + model + '\''
                + ", number='" + number + '\''
                + '}';
    }
}
