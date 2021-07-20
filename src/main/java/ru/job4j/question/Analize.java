package ru.job4j.question;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        int added = 0;
        int changed = 0;
        int deleted;
        Map<Integer, String> map = new HashMap<>();
        for (User us : previous) {
            map.put(us.getId(), us.getName());
        }
        for (User us : current) {
            if (map.get(us.getId()) != null
                    && us.getName().equals(map.get(us.getId()))) {
                map.remove(us.getId());
            } else if (map.get(us.getId()) != null
                    && !us.getName().equals(map.get(us.getId()))) {
                map.remove(us.getId());
                changed++;
            } else {
                added++;
            }
        }
        deleted = map.size();
        return new Info(added, changed, deleted);
    }
}