package com.franciscogiunta.ofertacomercial.service;

import com.franciscogiunta.ofertacomercial.entity.Localidad;
import com.franciscogiunta.ofertacomercial.entity.Zona;
import com.franciscogiunta.ofertacomercial.repository.LocalidadRepository;
import com.franciscogiunta.ofertacomercial.repository.ZonaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class LocalidadService {

    private final LocalidadRepository localidadRepository;
    private final ZonaRepository zonaRepository;

    public LocalidadService(LocalidadRepository localidadRepository, ZonaRepository zonaRepository) {
        this.localidadRepository = localidadRepository;
        this.zonaRepository = zonaRepository;
    }

    public List<Localidad> getLocalidadesByZonaId(Integer zonaId) {
        return localidadRepository.findByZona_ZonaId(zonaId);
    }

    @Transactional
    public Localidad createLocalidad(String nombre, Integer zonaId) {
        Zona zona = zonaRepository.findById(zonaId)
                .orElseThrow(() -> new IllegalArgumentException("La zona con ID " + zonaId + " no existe."));

        Localidad nuevaLocalidad = new Localidad(nombre, zona);
        return localidadRepository.save(nuevaLocalidad);
    }
}
