package com.franciscogiunta.ofertacomercial.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "localidades")
@Getter
@Setter
@NoArgsConstructor
public class Localidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "localidad_id")
    private Integer localidadId;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "zona_id", nullable = false)
    @JsonBackReference
    private Zona zona;

    public Localidad(String nombre, Zona zona) {
        this.nombre = nombre;
        this.zona = zona;
    }
}
