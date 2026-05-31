package com.franciscogiunta.ofertacomercial.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.math.BigDecimal;

@Entity
@Table(name = "packs_premium") // <--- ¡Nombre de tabla corregido!
public class PackPremium {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer packPremiumId; // Tipo de dato corregido a Integer

    private String nombre;
    private BigDecimal precio;
    private String promocionDesc;

    // --- CONSTRUCTORES ---
    // ... (Se mantienen igual)
    public PackPremium() {}
    public PackPremium(String nombre, BigDecimal precio, String promocionDesc) {
        this.nombre = nombre;
        this.precio = precio;
        this.promocionDesc = promocionDesc;
    }

    // --- GETTERS Y SETTERS ---
    // ... (Se mantienen igual, usando Integer)
    public Integer getPackPremiumId() { return packPremiumId; }
    public void setPackPremiumId(Integer packPremiumId) { this.packPremiumId = packPremiumId; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public BigDecimal getPrecio() { return precio; }
    public void setPrecio(BigDecimal precio) { this.precio = precio; }
    public String getPromocionDesc() { return promocionDesc; }
    public void setPromocionDesc(String promocionDesc) { this.promocionDesc = promocionDesc; }
}