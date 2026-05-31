package com.franciscogiunta.ofertacomercial.controller;

import com.franciscogiunta.ofertacomercial.entity.Localidad;
import com.franciscogiunta.ofertacomercial.service.LocalidadService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/localidades")
public class LocalidadController {

    private final LocalidadService localidadService;

    public LocalidadController(LocalidadService localidadService) {
        this.localidadService = localidadService;
    }

    @GetMapping("/zona/{zonaId}")
    public ResponseEntity<List<Localidad>> getLocalidadesByZona(@PathVariable Integer zonaId) {
        return ResponseEntity.ok(localidadService.getLocalidadesByZonaId(zonaId));
    }

    @PostMapping("/zona/{zonaId}")
    public ResponseEntity<Localidad> createLocalidad(@PathVariable Integer zonaId, @RequestBody Map<String, String> request) {
        try {
            String nombre = request.get("nombre");
            if (nombre == null || nombre.trim().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            Localidad nuevaLocalidad = localidadService.createLocalidad(nombre, zonaId);
            return ResponseEntity.ok(nuevaLocalidad);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
