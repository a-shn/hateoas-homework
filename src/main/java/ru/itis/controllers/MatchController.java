package ru.itis.controllers;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import ru.itis.services.Distributor;

@Controller
@AllArgsConstructor
public class MatchController {
    private final Distributor distributor;

    @GetMapping("/mastersDistribution")
    public String getMastersAndAdvisersMatch() {
        return distributor.advisersAndMastersDistribution().toString();
    }
}
