package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Telephone {

    private boolean onMarket;
    private int price;
    private Manufacturer manufacturer;
    private String[] parameters;

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

    public boolean isOnMarket() {
        return onMarket;
    }

    public void setOnMarket(boolean onMarket) {
        this.onMarket = onMarket;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String[] getParameters() {
        return parameters;
    }

    public void setParameters(String[] parameters) {
        this.parameters = parameters;
    }

    public static void main(String[] args) {
        /* JSONObject из json-строки строки */
        JSONObject jsonManufacturer = new JSONObject(
                "{"
                    + "\"companyName\":\"name\","
                    + "\"address\":\"address\","
                    + "\"phone\":\"+7(999)999-99-99\""
                + "}"
        );

        /* JSONArray из ArrayList */
        List<String> list = new ArrayList<>();
        list.add("black");
        list.add("touch");
        JSONArray jsonStatuses = new JSONArray(list);

        /* JSONObject напрямую методом put */
        final Telephone telephone = new Telephone(
                true,
                999,
                new Manufacturer("name", "address", "+7(999)999-99-99"),
                new String[] {"black", "touch"}
        );
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("onMarket", telephone.isOnMarket());
        jsonObject.put("price", telephone.getPrice());
        jsonObject.put("manufacturer", jsonManufacturer);
        jsonObject.put("parameters", jsonStatuses);

        /* Выведем результат в консоль */
        System.out.println(jsonObject.toString());

        /* Преобразуем объект person в json-строку */
        System.out.println(new JSONObject(telephone).toString());
    }
}
