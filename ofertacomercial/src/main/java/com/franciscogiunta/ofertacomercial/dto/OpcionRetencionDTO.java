package com.franciscogiunta.ofertacomercial.dto;

import lombok.Data;
import java.io.Serializable;

@Data
public class OpcionRetencionDTO implements Serializable {

    // Identificador de la opción dentro de Retención
    private String opcion; // Ej: "1", "2", "3", "4"

    // Datos de la Promoción
    private Double precioLista;
    private Double porcentajeDcto;
    private Integer vigencia; // En meses
    private String promocionDesc;
    private Double precioFinal;
}