package com.ejemplo.act1_introduccion_spring_boot.entities;
import jakarta.persistence.*;

@Entity
@Table(name = "figuras")
public class Figura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String personaje;

    private Double precio;

    // Relación Muchos a 1: Muchas figuras pertenecen a un anime
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "anime_id", nullable = false)
    private Anime anime;

    public Figura() {}

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getPersonaje() { return personaje; }
    public void setPersonaje(String personaje) { this.personaje = personaje; }
    public Double getPrecio() { return precio; }
    public void setPrecio(Double precio) { this.precio = precio; }
    public Anime getAnime() { return anime; }
    public void setAnime(Anime anime) { this.anime = anime; }
}