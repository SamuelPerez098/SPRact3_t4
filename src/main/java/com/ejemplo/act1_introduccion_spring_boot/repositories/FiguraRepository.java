package com.ejemplo.act1_introduccion_spring_boot.repositories;

import com.ejemplo.act1_introduccion_spring_boot.entities.Figura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FiguraRepository extends JpaRepository<Figura, Long> {
}