// com.franciscogiunta.ofertacomercial.repository.PaqueteRepository.java
package com.franciscogiunta.ofertacomercial.repository;

import com.franciscogiunta.ofertacomercial.entity.Paquete; // PAQUETE ACTUALIZADO
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaqueteRepository extends JpaRepository<Paquete, Integer> {}
// ... y de forma similar para ZonaRepository, PrecioCaptacionRepository y PrecioRetencionRepository.
