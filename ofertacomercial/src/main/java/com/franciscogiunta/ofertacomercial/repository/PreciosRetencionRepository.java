package com.franciscogiunta.ofertacomercial.repository;
import com.franciscogiunta.ofertacomercial.entity.PrecioRetencion; // PAQUETE ACTUALIZADO
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreciosRetencionRepository extends JpaRepository<PrecioRetencion, Integer> {}
