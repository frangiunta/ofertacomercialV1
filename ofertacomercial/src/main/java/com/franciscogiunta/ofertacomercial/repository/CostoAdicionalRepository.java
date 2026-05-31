package com.franciscogiunta.ofertacomercial.repository;

import com.franciscogiunta.ofertacomercial.entity.CostosAdicionales;
import org.springframework.data.jpa.repository.JpaRepository;

// El segundo argumento es el tipo de la clave primaria: Integer
public interface CostoAdicionalRepository extends JpaRepository<CostosAdicionales, Integer> {
    // Proporciona todos los métodos CRUD.
}
