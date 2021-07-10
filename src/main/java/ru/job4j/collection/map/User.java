package ru.job4j.collection.map;

import java.util.*;

public class User {

    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(1985, Calendar.JANUARY, 1);
        User user1 = new User("Oleg", 2, calendar);
        User user2 = new User("Oleg", 2, calendar);
        Map<User, Object> map = new HashMap<>();
        map.put(user1, new Object());
        map.put(user2, new Object());
        for (User us : map.keySet()) {
            System.out.println(us);
            System.out.println("хэш-код объекта = " + us.hashCode());
        }
        System.out.println("хэш-код объекта = " + user1.hashCode());
        System.out.println("хэш-код объекта = " + user2.hashCode());
    }
}
