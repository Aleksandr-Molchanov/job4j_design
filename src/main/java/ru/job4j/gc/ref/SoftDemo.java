package ru.job4j.gc.ref;

import ru.job4j.gc.User;

import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public class SoftDemo {

    public static void main(String[] args) {
        example2();
    }

    private static void example1() {
        Object strong = new Object();
        SoftReference<Object> soft = new SoftReference<>(strong);
        strong = null;
        System.out.println(soft.get());
    }

    private static void example2() {
        List<SoftReference<Object>> objects = new ArrayList<>();
        for (int i = 0; i < 15_000_000; i++) {
            objects.add(new SoftReference<Object>(new Object() {
                String value = String.valueOf(System.currentTimeMillis());

                @Override
                protected void finalize() throws Throwable {
                    System.out.println("Object removed!");
                }
            }));
        }
        System.gc();
        int liveObject = 0;
        for (SoftReference<Object> ref : objects) {
            Object object = ref.get();
            if (object != null) {
                liveObject++;
            }
        }
        System.out.println(liveObject);
    }

    private static void safe(List<SoftReference<User>> users) {
        int count = 0;
        for (SoftReference<User> us : users) {
            User user = us.get();
            count++;
            if (user != null) {
                System.out.println("Хип еще не заполнен");
                System.out.println("Логин пользователя под номером " + count + "- " + user.getLogin());
            } else {
                System.out.println("Хип уже был заполнен, сработал GC");
                System.out.println("Пользователь под номером " + count + " удален");
            }
        }
    }

}