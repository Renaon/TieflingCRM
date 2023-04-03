package com.crm.Tiefling.arch.pair;

import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args) {
        Pair<Integer, Integer> p1 = new Pair<>(1,1);
        Pair<Integer, Integer> p2 = new Pair<>(1,1);

        Map<Pair<Integer, Integer>, Integer> map = new HashMap<>();

        map.put(p1, 1);
        map.put(p2, 1);

        System.out.println(map.size());
    }
}
