package com.franciscogiunta.ofertacomercial.repository;

import com.franciscogiunta.ofertacomercial.entity.Zona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ZonaRepository extends JpaRepository<Zona, Integer> {
    Optional<Zona> findByNombre(String nombre);
}
