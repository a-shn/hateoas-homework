package ru.itis.services;

import ru.itis.models.AcademicAdviser;
import ru.itis.models.Master;

import java.util.Map;

public interface Distributor {
    Map<AcademicAdviser, Master> advisersAndMastersDistribution();
}
