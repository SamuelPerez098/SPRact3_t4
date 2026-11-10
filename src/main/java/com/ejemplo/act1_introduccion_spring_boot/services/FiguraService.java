package com.ejemplo.act1_introduccion_spring_boot.services;

import com.ejemplo.act1_introduccion_spring_boot.entities.Anime;
import com.ejemplo.act1_introduccion_spring_boot.entities.Figura;
import com.ejemplo.act1_introduccion_spring_boot.repositories.AnimeRepository;
import com.ejemplo.act1_introduccion_spring_boot.repositories.FiguraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FiguraService {

    @Autowired
    private FiguraRepository figuraRepository;

    @Autowired
    private AnimeRepository animeRepository;

    public List<Figura> listarTodas() {
        return figuraRepository.findAll();
    }

    public Optional<Figura> buscarPorId(Long id) {
        return figuraRepository.findById(id);
    }

    public Figura guardar(Figura figura) {
        Anime anime = animeRepository.findById(figura.getAnime().getId())
                .orElseThrow(() -> new RuntimeException("Anime no encontrado"));
        figura.setAnime(anime);
        return figuraRepository.save(figura);
    }

    public void eliminar(Long id) {
        figuraRepository.deleteById(id);
    }
}