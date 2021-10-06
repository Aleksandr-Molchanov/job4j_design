package ru.job4j.design.srp;

import java.util.function.Predicate;

public class ITReportEngine implements Report {

    private Store store;

    public ITReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("<html>")
                .append("<head>")
                .append("<title>IT Report</title>")
                .append("</head>")
                .append(System.lineSeparator())
                .append("<body>")
                .append(System.lineSeparator())
                .append("<h1>Name; Hired; Fired; Salary;</h1>");
        for (Employee employee : store.findBy(filter)) {
            text.append("<p>")
                    .append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append("</p>")
                    .append(System.lineSeparator())
                    .append("</body>")
                    .append("</html>")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
