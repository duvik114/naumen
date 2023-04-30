package com.example.naumen.store;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Getter
@Setter
public class Store {

    private Map<String, NameStat> map = new HashMap<>();
    private String oldestName;

    public Store(List<String> lines) {
        for (String line : lines) {
            String name = line.split("_")[0];
            int age = Integer.parseInt(line.split("_")[1]);
            map.put(name, new NameStat(age, 0));
            updateOldest(name);
        }
    }

    public NameRequests[] getRequests() {
        return map.entrySet().stream()
                .map(e -> new NameRequests(e.getKey(), e.getValue().getRequests()))
                .toArray(NameRequests[]::new);
    }

    public int getAge(String name) {
        if (!map.containsKey(name)) {
            Random r = new Random();
            int age = r.nextInt();
            map.put(name, new NameStat(age, 0));
            updateOldest(name);
        }

        return map.get(name).incAndGet();
    }

    private void updateOldest(String name) {
        if ((!map.containsKey(oldestName)) || map.get(oldestName).getAge() < map.get(name).getAge()) {
            oldestName = name;
        }
    }
}
