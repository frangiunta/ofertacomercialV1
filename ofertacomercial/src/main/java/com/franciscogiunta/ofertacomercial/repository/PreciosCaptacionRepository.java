package com.franciscogiunta.ofertacomercial.repository;
import com.franciscogiunta.ofertacomercial.entity.PrecioCaptacion; // PAQUETE ACTUALIZADO
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PreciosCaptacionRepository extends JpaRepository<PrecioCaptacion, Integer> {}