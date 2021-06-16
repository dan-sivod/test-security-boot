package com.dansivod.springsecuritydemo.rest;

import com.dansivod.springsecuritydemo.model.Developer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/developers")
public class DeveloperRestControllerV1 {

    List<Developer> developers = Stream.of(
            new Developer(1L, "Ivan", "Petrov"),
            new Developer(2L,"Natali", "Olegovna"),
            new Developer(3L, "Tim", "Olli")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll(){
        return this.developers;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable("id") Long id){
        return developers.stream().filter(developer -> developer.getId().equals(id))
                                    .findFirst()
                                    .orElse(null);
    }
}
