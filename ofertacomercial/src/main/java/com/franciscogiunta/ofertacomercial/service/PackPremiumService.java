package com.franciscogiunta.ofertacomercial.service;

import com.franciscogiunta.ofertacomercial.entity.PackPremium;
import com.franciscogiunta.ofertacomercial.repository.PackPremiumRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class PackPremiumService {

    private final PackPremiumRepository packPremiumRepository;

    public PackPremiumService(PackPremiumRepository packPremiumRepository) {
        this.packPremiumRepository = packPremiumRepository;
    }

    // CREATE / UPDATE
    public PackPremium savePackPremium(PackPremium packPremium) {
        return packPremiumRepository.save(packPremium);
    }

    // READ ALL
    public List<PackPremium> getAllPackPremiums() {
        return packPremiumRepository.findAll();
    }

    // READ BY ID
    public Optional<PackPremium> getPackPremiumById(Integer id) { // <--- Integer
        return packPremiumRepository.findById(id);
    }

    // DELETE
    public boolean deletePackPremium(Integer id) { // <--- Integer
        if (packPremiumRepository.existsById(id)) {
            packPremiumRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
