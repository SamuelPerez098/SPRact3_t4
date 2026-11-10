package com.ejemplo.act1_introduccion_spring_boot.repositories;

import com.ejemplo.act1_introduccion_spring_boot.entities.Anime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnimeRepository extends JpaRepository<Anime, Long> {
}