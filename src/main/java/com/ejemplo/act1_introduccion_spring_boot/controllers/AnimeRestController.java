package com.ejemplo.act1_introduccion_spring_boot.controllers;

import com.ejemplo.act1_introduccion_spring_boot.entities.Anime;
import com.ejemplo.act1_introduccion_spring_boot.repositories.AnimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/animes")
public class AnimeRestController {

    @Autowired
    private AnimeRepository animeRepository;

    @GetMapping
    public List<Anime> listar() {
        return animeRepository.findAll();
    }

    @PostMapping
    public Anime crear(@RequestBody Anime anime) {
        return animeRepository.save(anime);
    }
}