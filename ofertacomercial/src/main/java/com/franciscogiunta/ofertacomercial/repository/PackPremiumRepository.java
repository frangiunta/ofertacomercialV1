package com.franciscogiunta.ofertacomercial.repository;

import com.franciscogiunta.ofertacomercial.entity.PackPremium;
import org.springframework.data.jpa.repository.JpaRepository;

// El segundo argumento es el tipo de la clave primaria: Integer
public interface PackPremiumRepository extends JpaRepository<PackPremium, Integer> {
    // ...
}
