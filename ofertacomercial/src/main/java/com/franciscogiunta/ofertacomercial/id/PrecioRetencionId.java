package com.franciscogiunta.ofertacomercial.id;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PrecioRetencionId implements Serializable {
    private Integer zona;
    private Integer paquete;
    private String opcion;
}