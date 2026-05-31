package com.franciscogiunta.ofertacomercial.service;

import com.franciscogiunta.ofertacomercial.entity.CostosAdicionales;
import com.franciscogiunta.ofertacomercial.repository.CostoAdicionalRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class CostoAdicionalService {

    private final CostoAdicionalRepository costoAdicionalRepository;

    public CostoAdicionalService(CostoAdicionalRepository costoAdicionalRepository) {
        this.costoAdicionalRepository = costoAdicionalRepository;
    }

    // CREATE / UPDATE
    public CostosAdicionales saveCostoAdicional(CostosAdicionales costo) {
        return costoAdicionalRepository.save(costo);
    }

    // READ ALL
    public List<CostosAdicionales> getAllCostosAdicionales() {
        return costoAdicionalRepository.findAll();
    }

    // READ BY ID
    public Optional<CostosAdicionales> getCostoAdicionalById(Integer id) {
        return costoAdicionalRepository.findById(id);
    }

    // DELETE
    public boolean deleteCostoAdicional(Integer id) {
        if (costoAdicionalRepository.existsById(id)) {
            costoAdicionalRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
