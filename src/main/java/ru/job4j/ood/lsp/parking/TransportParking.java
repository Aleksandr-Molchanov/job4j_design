package ru.job4j.ood.lsp.parking;

public class TransportParking implements Parking {

    private int car = 0;

    private int truck = 0;

    private Transport[] cars;

    private Transport[] trucks;

    public TransportParking(int carsSize, int trucksSize) {
        cars = new Transport[carsSize];
        trucks = new Transport[trucksSize];
    }

    @Override
    public boolean park(Transport transport) {
        boolean rsl = false;
        if (transport.size() < 1) {
            throw new IllegalArgumentException("Размер транспорта не может быть меньше 1.");
        }
        if (transport.size() > 1 && truck < trucks.length) {
            trucks[car] = transport;
            truck++;
            rsl = true;
        }
        if (transport.size() > 1 && truck == trucks.length
                && cars.length - car >= transport.size()) {
            cars[car] = transport;
            car += transport.size();
            rsl = true;
        }
        if (transport.size() == 1 && car < cars.length) {
            cars[car] = transport;
            car++;
            rsl = true;
        }
        return rsl;
    }
}
