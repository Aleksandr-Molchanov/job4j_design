package ru.job4j.ood.lsp.parking;

import org.junit.Test;

import static org.junit.Assert.*;

public class ParkingTest {

    @Test
    public void whenSedanParked() {
        Parking parking = new TransportParking(1, 1);
        Transport car = new Car("a001aa");
        assertTrue(parking.park(car));
    }

    @Test
    public void whenSedanTruck() {
        Parking parking = new TransportParking(1, 1);
        Transport truck = new Truck("b001bb", 2);
        assertTrue(parking.park(truck));
    }

    @Test
    public void whenThereIsNoParkingSpace() {
        Parking parking = new TransportParking(0, 0);
        Transport car = new Car("a001aa");
        Transport truck = new Truck("b001bb", 2);
        assertFalse(parking.park(car));
        assertFalse(parking.park(truck));
    }

    @Test
    public void whenThereIsNotEnoughSpaceForASedan() {
        Parking parking = new TransportParking(1, 1);
        Transport car1 = new Car("a001aa");
        Transport car2 = new Car("a002aa");
        assertTrue(parking.park(car1));
        assertFalse(parking.park(car2));
    }

    @Test
    public void whenThereIsNotEnoughSpaceForATruck() {
        Parking parking = new TransportParking(1, 1);
        Transport truck1 = new Truck("b001bb", 2);
        Transport truck2 = new Truck("b002bb", 2);
        assertTrue(parking.park(truck1));
        assertFalse(parking.park(truck2));
    }

    @Test
    public void whenACarCannotTakeThePlaceOfATruck() {
        Parking parking = new TransportParking(0, 1);
        Transport car = new Car("a001aa");
        assertFalse(parking.park(car));
    }

    @Test
    public void whenTheTruckHasAPlaceInTheSeatsForCars() {
        Parking parking = new TransportParking(2, 0);
        Transport truck = new Truck("b001bb", 2);
        assertTrue(parking.park(truck));
    }

    @Test
    public void whenThereIsNoPlaceForATruckInTheSeatsForCars() {
        Parking parking = new TransportParking(1, 0);
        Transport truck = new Truck("b001bb", 2);
        assertFalse(parking.park(truck));
    }
}