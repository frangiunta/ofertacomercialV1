// com.franciscogiunta.ofertacomercial.controller.OfertaComercialController.java
package com.franciscogiunta.ofertacomercial.controller;

// Importaciones actualizadas
import com.franciscogiunta.ofertacomercial.dto.OfertaCaptacionDTO;
import com.franciscogiunta.ofertacomercial.dto.PaqueteRetencionDTO;
import com.franciscogiunta.ofertacomercial.service.OfertaComercialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ofertas")
public class OfertaComercialController {

    private final OfertaComercialService ofertaComercialService;

    public OfertaComercialController(OfertaComercialService ofertaComercialService) {
        this.ofertaComercialService = ofertaComercialService;
    }

    @GetMapping("/captacion/{zonaId}")
    public ResponseEntity<List<OfertaCaptacionDTO>> getCaptacionPorZona(@PathVariable Integer zonaId) {
        List<OfertaCaptacionDTO> ofertas = ofertaComercialService.getOfertaCaptacionByZona(zonaId);
        if (ofertas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ofertas);
    }

    @GetMapping("/retencion/{zonaId}")
    public ResponseEntity<List<PaqueteRetencionDTO>> getRetencionPorZona(@PathVariable Integer zonaId) {
        List<PaqueteRetencionDTO> ofertas = ofertaComercialService.getOfertaRetencionByZona(zonaId);
        if (ofertas.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ofertas);
    }
}
