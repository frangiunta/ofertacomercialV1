
// com.franciscogiunta.ofertacomercial.model.id.PrecioCaptacionId.java
package com.franciscogiunta.ofertacomercial.id;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class PrecioCaptacionId implements Serializable {
    private Integer zona;
    private Integer paquete;
}
