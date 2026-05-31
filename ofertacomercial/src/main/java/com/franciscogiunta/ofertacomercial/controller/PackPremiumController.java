package com.franciscogiunta.ofertacomercial.controller;

import com.franciscogiunta.ofertacomercial.entity.PackPremium;
import com.franciscogiunta.ofertacomercial.service.PackPremiumService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/packpremiums") // El endpoint sigue siendo plural, lo estándar
public class PackPremiumController {

    private final PackPremiumService packPremiumService;

    public PackPremiumController(PackPremiumService packPremiumService) {
        this.packPremiumService = packPremiumService;
    }

    // POST: CREAR
    @PostMapping
    public ResponseEntity<PackPremium> createPackPremium(@RequestBody PackPremium packPremium) {
        PackPremium nuevoPackPremium = packPremiumService.savePackPremium(packPremium);
        return new ResponseEntity<>(nuevoPackPremium, HttpStatus.CREATED);
    }

    // GET: VER todos
    @GetMapping
    public ResponseEntity<List<PackPremium>> getAllPackPremiums() {
        List<PackPremium> packs = packPremiumService.getAllPackPremiums();
        return new ResponseEntity<>(packs, HttpStatus.OK);
    }

    // GET: VER por ID
    @GetMapping("/{id}")
    public ResponseEntity<PackPremium> getPackPremiumById(@PathVariable Integer id) { // <--- Integer
        return packPremiumService.getPackPremiumById(id)
                .map(pack -> new ResponseEntity<>(pack, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // PUT: EDITAR (Actualizar)
    @PutMapping("/{id}")
    public ResponseEntity<PackPremium> updatePackPremium(@PathVariable Integer id, @RequestBody PackPremium details) { // <--- Integer
        return packPremiumService.getPackPremiumById(id)
                .map(existingPack -> {
                    // Mapeo de campos...
                    existingPack.setNombre(details.getNombre());
                    existingPack.setPrecio(details.getPrecio());
                    existingPack.setPromocionDesc(details.getPromocionDesc());

                    PackPremium updatedPack = packPremiumService.savePackPremium(existingPack);
                    return new ResponseEntity<>(updatedPack, HttpStatus.OK);
                })
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    // DELETE: BORRAR
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePackPremium(@PathVariable Integer id) { // <--- Integer
        if (packPremiumService.deletePackPremium(id)) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // 204
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

