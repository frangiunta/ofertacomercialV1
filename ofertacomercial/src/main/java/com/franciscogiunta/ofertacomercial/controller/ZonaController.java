package com.franciscogiunta.ofertacomercial.controller;

import com.franciscogiunta.ofertacomercial.entity.Zona;
import com.franciscogiunta.ofertacomercial.service.ZonaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/zonas")
public class ZonaController {

    private final ZonaService zonaService;

    public ZonaController(ZonaService zonaService) {
        this.zonaService = zonaService;
    }

    @GetMapping
    public ResponseEntity<List<Zona>> getAllZonas() {
        return ResponseEntity.ok(zonaService.getAllZonas());
    }

    @PostMapping
    public ResponseEntity<Zona> createZona(@RequestBody String nombre) {
        try {
            Zona nuevaZona = zonaService.createZona(nombre);
            return ResponseEntity.ok(nuevaZona);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
