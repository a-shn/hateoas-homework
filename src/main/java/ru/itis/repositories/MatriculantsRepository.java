package ru.itis.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class MyProfileController {
    @Autowired
    private BachelorsService bachelorsService;
    @RequestMapping(value = "/bachelors/{bachelor-id}", method = RequestMethod.GET)
    @ResponseBody
    public ResponseEntity<?> getProfileByUserId(@PathVariable("bachelor-id") Long bachelorId) {
        return ResponseEntity.ok(EntityModel.of(bachelorsService.getBachelor(bachelorId)));
    }
}