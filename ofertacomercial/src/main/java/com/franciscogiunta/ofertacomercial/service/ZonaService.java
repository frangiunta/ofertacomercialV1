package com.franciscogiunta.ofertacomercial.service;

import com.franciscogiunta.ofertacomercial.entity.Zona;
import com.franciscogiunta.ofertacomercial.repository.ZonaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ZonaService {

    private final ZonaRepository zonaRepository;

    public ZonaService(ZonaRepository zonaRepository) {
        this.zonaRepository = zonaRepository;
    }

    public List<Zona> getAllZonas() {
        return zonaRepository.findAll();
    }

    public Zona createZona(String nombre) {
        Optional<Zona> existingZona = zonaRepository.findByNombre(nombre);
        if (existingZona.isPresent()) {
            throw new IllegalArgumentException("La zona con el nombre '" + nombre + "' ya existe.");
        }
        Zona nuevaZona = new Zona(nombre);
        return zonaRepository.save(nuevaZona);
    }
}
