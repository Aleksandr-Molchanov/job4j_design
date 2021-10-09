package ru.job4j.design.srp;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.function.Predicate;

public class XMLReportEngine implements Report {

    private Store store;

    public XMLReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder xml = new StringBuilder();
        for (Employee employee : store.findBy(filter)) {
            JAXBContext context = null;
            try (StringWriter writer = new StringWriter()) {
                context = JAXBContext.newInstance(Employee.class);
                Marshaller marshaller = context.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                marshaller.marshal(employee, writer);
                xml.append(writer.getBuffer().toString());
            } catch (JAXBException | IOException e) {
                e.printStackTrace();
            }
        }
        return xml.toString();
    }
}
