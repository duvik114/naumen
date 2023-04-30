package com.example.naumen.store;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class NameStat {

    private int age;
    private int requests;

    public int incAndGet() {
        requests++;
        return age;
    }
}
