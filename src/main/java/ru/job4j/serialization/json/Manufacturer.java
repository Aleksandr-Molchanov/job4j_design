package ru.job4j.serialization.json;

public class Manufacturer {

    private String companyName;

    private String address;

    private String phone;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
