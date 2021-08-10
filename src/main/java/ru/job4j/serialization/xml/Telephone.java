package ru.job4j.serialization.xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.annotation.*;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "telephone")
@XmlAccessorType(XmlAccessType.FIELD)
public class Telephone {

    @XmlAttribute
    private boolean onMarket;

    @XmlAttribute
    private int price;

    @XmlElement
    private Manufacturer manufacturer;

    @XmlElementWrapper(name = "parameters")
    @XmlElement(name = "parameter")
    private String[] parameters;

    public Telephone() {
    }

    public Telephone(boolean onMarket, int price, Manufacturer manufacturer, String[] parameters) {
        this.onMarket = onMarket;
        this.price = price;
        this.manufacturer = manufacturer;
        this.parameters = parameters;
    }

    @Override
    public String toString() {
        return "Telephone{"
                + "onMarket=" + onMarket
                + ", price=" + price
                + ", manufacturer=" + manufacturer
                + ", parameters=" + Arrays.toString(parameters)
                + '}';
    }

    public static void main(String[] args) throws JAXBException, IOException {
        final Telephone telephone = new Telephone(
                true,
                999,
                new Manufacturer("name", "address", "+7(999)999-99-99"),
                new String[] {"black", "touch"}
        );

        JAXBContext context = JAXBContext.newInstance(Telephone.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        String xml = "";
        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(telephone, writer);
            xml = writer.getBuffer().toString();
            System.out.println(xml);
        }
        Unmarshaller unmarshaller = context.createUnmarshaller();
        try (StringReader reader = new StringReader(xml)) {
            Telephone result = (Telephone) unmarshaller.unmarshal(reader);
            System.out.println(result);
        }
    }
}