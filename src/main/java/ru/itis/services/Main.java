package ru.itis.services;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static java.util.Arrays.asList;
import static java.util.Arrays.sort;

public class Main {
    public static void main(String[] args) {
        GaleShapleyAlgorithmImpl gsa = new GaleShapleyAlgorithmImpl();
        Map<Long, List<Long>> men = new HashMap<>();
        Map<Long, List<Long>> women = new HashMap<>();
        men.put(1L, new LinkedList<>(asList(5L, 4L, 3L, 2L, 1L)));
        men.put(2L, new LinkedList<>(asList(1L, 5L, 4L, 3L, 2L)));
        men.put(3L, new LinkedList<>(asList(2L, 1L, 5L, 4L, 3L)));
        men.put(4L, new LinkedList<>(asList(3L, 2L, 1L, 5L, 4L)));
        men.put(5L, new LinkedList<>(asList(4L, 3L, 2L, 1L, 5L)));
        women.put(1L, new LinkedList<>(asList(1L, 2L, 3L, 4L, 5L)));
        women.put(2L, new LinkedList<>(asList(2L, 3L, 4L, 5L, 1L)));
        women.put(3L, new LinkedList<>(asList(3L, 4L, 5L, 1L, 2L)));
        women.put(4L, new LinkedList<>(asList(4L, 5L, 1L, 2L, 3L)));
        women.put(5L, new LinkedList<>(asList(5L, 1L, 2L, 3L, 4L)));
//        Map<Long, Long> pairs = gsa.match(men, women);
//        System.out.println(pairs);;
    }
}
