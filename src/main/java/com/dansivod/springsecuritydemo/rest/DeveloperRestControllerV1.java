package com.dansivod.springsecuritydemo.rest;

import com.dansivod.springsecuritydemo.model.Developer;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("api/v1/developers")
public class DeveloperRestControllerV1 {

    List<Developer> DEVELOPERS = Stream.of(
            new Developer(1L, "Ivan", "Petrov"),
            new Developer(2L,"Natali", "Olegovna"),
            new Developer(3L, "Tim", "Olli")
    ).collect(Collectors.toList());

    @GetMapping
    public List<Developer> getAll(){
        return this.DEVELOPERS;
    }

    @GetMapping("/{id}")
    public Developer getById(@PathVariable("id") Long id){
        return DEVELOPERS.stream().filter(developer -> developer.getId().equals(id))
                                    .findFirst()
                                    .orElse(null);
    }

    @PostMapping
    public Developer create(@RequestBody Developer developer){
        this.DEVELOPERS.add(developer);
        return developer;
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        this.DEVELOPERS.removeIf(developer -> developer.getId().equals(id));
    }
}
