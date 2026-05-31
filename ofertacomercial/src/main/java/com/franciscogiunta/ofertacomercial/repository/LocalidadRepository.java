package com.franciscogiunta.ofertacomercial.repository;

import com.franciscogiunta.ofertacomercial.entity.Localidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LocalidadRepository extends JpaRepository<Localidad, Integer> {
    List<Localidad> findByZona_ZonaId(Integer zonaId);
}
