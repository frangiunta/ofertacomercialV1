// com.franciscogiunta.ofertacomercial.service.OfertaComercialService.java
package com.franciscogiunta.ofertacomercial.service;

import com.franciscogiunta.ofertacomercial.dto.OfertaCaptacionDTO; // PAQUETE ACTUALIZADO
import com.franciscogiunta.ofertacomercial.dto.PaqueteRetencionDTO; // PAQUETE ACTUALIZADO
import java.util.List;

public interface OfertaComercialService {
    List<OfertaCaptacionDTO> getOfertaCaptacionByZona(Integer zonaId);
    List<PaqueteRetencionDTO> getOfertaRetencionByZona(Integer zonaId);


}
