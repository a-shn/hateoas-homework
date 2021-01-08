package ru.itis.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.itis.models.AcademicAdviser;
import ru.itis.models.Master;
import ru.itis.services.Distributor;

import java.util.Map;

@RestController
@AllArgsConstructor
public class MatchController {
    private final Distributor distributor;

    @GetMapping("/mastersDistribution")
    public Map<AcademicAdviser, Master> getMastersAndAdvisersMatch() {
        Map<AcademicAdviser, Master> result = distributor.advisersAndMastersDistribution();
        return result;
    }
}
