package ru.job4j.serialization.xml;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "manufacturer")
public class Manufacturer {

    @XmlAttribute
    private String companyName;

    @XmlAttribute
    private String address;

    @XmlAttribute
    private String phone;

    public Manufacturer() {
    }

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