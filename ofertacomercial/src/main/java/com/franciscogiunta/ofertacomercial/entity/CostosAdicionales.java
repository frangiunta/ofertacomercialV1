package com.franciscogiunta.ofertacomercial.entity;

import jakarta.persistence.Column; // ¡Necesitas esta importación!
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "costos_adicionales")
public class CostosAdicionales {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer costoAdicionalId;

    private String nombre;

    // Mapeo corregido: Le decimos a Hibernate que este campo 'costo'
    // corresponde a la columna 'precio' en la base de datos.
    @Column(name = "precio")
    private BigDecimal costo;

    // --- CONSTRUCTORES ---

    public CostosAdicionales() {}

    public CostosAdicionales(String nombre, BigDecimal costo) {
        this.nombre = nombre;
        this.costo = costo;
    }

    // --- GETTERS Y SETTERS ---

    public Integer getCostoAdicionalId() {
        return costoAdicionalId;
    }

    public void setCostoAdicionalId(Integer costoAdicionalId) {
        this.costoAdicionalId = costoAdicionalId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }
}