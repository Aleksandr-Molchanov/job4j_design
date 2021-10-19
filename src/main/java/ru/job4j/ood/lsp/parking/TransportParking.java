package ru.job4j.ood.lsp.parking;

public class TransportParking implements Parking {

    private int car;

    private int truck;

    private int[] cars;

    private int[] trucks;

    public TransportParking(int car, int truck) {
        this.car = car;
        this.truck = truck;
    }

    @Override
    public boolean park(Transport transport) {
        return false;
    }
}
