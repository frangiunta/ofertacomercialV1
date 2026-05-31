package com.franciscogiunta.ofertacomercial.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "zonas")
@Getter
@Setter
@NoArgsConstructor
public class Zona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "zona_id")
    private Integer zonaId;

    @Column(name = "nombre", nullable = false, unique = true)
    private String nombre;

    @OneToMany(mappedBy = "zona", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Localidad> localidades = new ArrayList<>();

    public Zona(String nombre) {
        this.nombre = nombre;
    }
    
    // Método auxiliar para agregar localidades manteniendo la relación bidireccional
    public void addLocalidad(Localidad localidad) {
        localidades.add(localidad);
        localidad.setZona(this);
    }

    public void removeLocalidad(Localidad localidad) {
        localidades.remove(localidad);
        localidad.setZona(null);
    }
}
