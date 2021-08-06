package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.job4j.serialization.json.Manufacturer;

import java.util.Arrays;

public class Telephone {

    private final boolean onMarket;
    private final int price;
    private final Manufacturer manufacturer;
    private final String[] parameters;

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

    public static void main(String[] args) {
        final Telephone telephone = new Telephone(
                true,
                999,
                new Manufacturer("name", "address", "+7(999)999-99-99"),
                new String[] {"black", "touch"}
        );

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(telephone));

        /* Модифицируем json-строку */
        final String personJson =
                "{"
                        + "\"onMarker\":true,"
                        + "\"price\":999,"
                        + "\"manufacturer\":"
                            + "{"
                                + "\"companyName\":\"name\","
                                + "\"address\":\"address\","
                                + "\"phone\":\"+7(999)999-99-99\""
                            + "},"
                        + "\"parameters\":"
                        + "[\"black\",\"touch\"]"
                + "}";
        final Telephone telephoneMod = gson.fromJson(personJson, Telephone.class);
        System.out.println(telephoneMod);
    }
}
