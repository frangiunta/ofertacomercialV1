package com.franciscogiunta.ofertacomercial.dto;

import lombok.Data;
import java.io.Serializable;
import java.util.List;

@Data
public class PaqueteRetencionDTO implements Serializable {

    // Datos del Paquete
    private Integer paqueteId;
    private String nombreDelPaquete;
    private String categoria;

    // Lista de las opciones de precio disponibles para este paquete
    // Utilizamos la clase OpcionRetencionDTO definida arriba.
    private List<OpcionRetencionDTO> opciones;
}
