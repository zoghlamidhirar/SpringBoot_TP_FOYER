package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;


import java.util.List;

@Service
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    FoyerRepository FoyerRepository;

    public List<Foyer> retrieveAllFoyers() {
        return FoyerRepository.findAll();
    }

    public Foyer retrieveFoyer(Long FoyerId) {
        return FoyerRepository.findById(FoyerId).get();
    }

    public Foyer addFoyer(Foyer c) {
        return FoyerRepository.save(c);
    }

    public void removeFoyer(Long FoyerId) {
        FoyerRepository.deleteById(FoyerId);
    }

    public Foyer modifyFoyer(Foyer Foyer) {
        return FoyerRepository.save(Foyer);
    }
}