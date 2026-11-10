package com.ejemplo.act1_introduccion_spring_boot.controllers;

import com.ejemplo.act1_introduccion_spring_boot.entities.Figura;
import com.ejemplo.act1_introduccion_spring_boot.services.FiguraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/figuras")
public class FiguraRestController {

    @Autowired
    private FiguraService figuraService;

    // 1. LEER TODAS (GET)
    @GetMapping
    public List<Figura> listar() {
        return figuraService.listarTodas();
    }

    // 2. LEER POR ID (GET)
    @GetMapping("/{id}")
    public ResponseEntity<Figura> obtenerPorId(@PathVariable Long id) {
        return figuraService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // 3. CREAR (POST)
    @PostMapping
    public Figura crear(@RequestBody Figura figura) {
        return figuraService.guardar(figura);
    }

    // 4. ACTUALIZAR (PUT)
    @PutMapping("/{id}")
    public ResponseEntity<Figura> actualizar(@PathVariable Long id, @RequestBody Figura figuraDetalles) {
        return figuraService.buscarPorId(id).map(f -> {
            f.setPersonaje(figuraDetalles.getPersonaje());
            f.setPrecio(figuraDetalles.getPrecio());
            f.setAnime(figuraDetalles.getAnime());
            return ResponseEntity.ok(figuraService.guardar(f));
        }).orElse(ResponseEntity.notFound().build());
    }

    // 5. ELIMINAR (DELETE)
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (figuraService.buscarPorId(id).isPresent()) {
            figuraService.eliminar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}