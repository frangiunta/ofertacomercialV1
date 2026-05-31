package com.franciscogiunta.ofertacomercial.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class OfertaCaptacionDTO implements Serializable {

    // Datos del Paquete
    private Integer paqueteId;
    private String nombreDelPaquete;
    private String categoria;

    // Datos de la Promoción de Captación
    private Double precioLista;
    private Double porcentajeDcto;
    private Integer vigencia; // En meses
    private String promocionDesc;
    private Double precioFinal;
}
