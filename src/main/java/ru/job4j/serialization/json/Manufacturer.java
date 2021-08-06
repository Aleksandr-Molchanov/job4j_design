package ru.job4j.serialization.json;

public class Manufacturer {

    private final String companyName;

    private final String address;

    private final String phone;

    public Manufacturer(String companyName, String address, String phone) {
        this.companyName = companyName;
        this.address = address;
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Manufacturer{"
                + "companyName='" + companyName + '\''
                + ", address='" + address + '\''
                + ", phone='" + phone + '\''
                + '}';
    }
}
