package ru.job4j.design.srp;

import org.json.JSONArray;

import java.util.List;
import java.util.function.Predicate;

public class JSONReportEngine implements Report {

    private Store store;

    public JSONReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        List<Employee> list = store.findBy(filter);
        JSONArray jsonList = new JSONArray(list);
        return jsonList.toString();
    }
}
