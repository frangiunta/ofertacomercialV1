package com.franciscogiunta.ofertacomercial.controller;

import com.franciscogiunta.ofertacomercial.entity.CostosAdicionales;
import com.franciscogiunta.ofertacomercial.service.CostoAdicionalService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/costosadicionales") // Endpoint base
public class CostoAdicionalController {

    private final CostoAdicionalService costoAdicionalService;

    public CostoAdicionalController(CostoAdicionalService costoAdicionalService) {
        this.costoAdicionalService = costoAdicionalService;
    }

    // POST: CREAR nuevo costo
    @PostMapping
    public ResponseEntity<CostosAdicionales> createCostoAdicional(@RequestBody CostosAdicionales costo) {
        CostosAdicionales nuevoCosto = costoAdicionalService.saveCostoAdicional(costo);
        return new ResponseEntity<>(nuevoCosto, HttpStatus.CREATED);
    }

    // GET: VER todos los costos
    @GetMapping
    public ResponseEntity<List<CostosAdicionales>> getAllCostosAdicionales() {
        List<CostosAdicionales> costos = costoAdicionalService.getAllCostosAdicionales();
        return new ResponseEntity<>(costos, HttpStatus.OK);
    }

    // GET: VER costo por ID
    @GetMapping("/{id}")
    public ResponseEntity<CostosAdicionales> getCostoAdicionalById(@PathVariable Integer id) {
        return costoAdicionalService.getCostoAdicionalById(id)
                .map(costo -> new ResponseEntity<>(costo, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // PUT: EDITAR (Actualizar)
    @PutMapping("/{id}")
    public ResponseEntity<CostosAdicionales> updateCostoAdicional(@PathVariable Integer id, @RequestBody CostosAdicionales details) {
        return costoAdicionalService.getCostoAdicionalById(id)
                .map(existingCosto -> {
                    // Actualiza solo los campos de datos
                    existingCosto.setNombre(details.getNombre());
                    existingCosto.setCosto(details.getCosto());

                    CostosAdicionales updatedCosto = costoAdicionalService.saveCostoAdicional(existingCosto);
                    return new ResponseEntity<>(updatedCosto, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE: BORRAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCostoAdicional(@PathVariable Integer id) {
        if (costoAdicionalService.deleteCostoAdicional(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}
