package com.franciscogiunta.ofertacomercial.repository;
import com.franciscogiunta.ofertacomercial.entity.Zona; // PAQUETE ACTUALIZADO
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ZonaRepository extends JpaRepository<Zona, Integer> {}
// ... y de forma similar para ZonaRepository, PrecioCaptacionRepository y PrecioRetencionRepository.
