package ru.itis.services;

import java.util.List;
import java.util.Map;

public interface GaleShapleyAlgorithm {
    Map<Object, Object> match(Map<Object, List<Object>> men, Map<Object, List<Object>> women);
}
