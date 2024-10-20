package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Universite;
import tn.esprit.tpfoyer.repository.UniversiteRepository;


import java.util.List;

@Service
@AllArgsConstructor
public class UniversiteServiceImpl implements IUniversiteService {
    UniversiteRepository UniversiteRepository;

    public List<Universite> retrieveAllUniversites() {
        return UniversiteRepository.findAll();
    }

    public Universite retrieveUniversite(Long UniversiteId) {
        return UniversiteRepository.findById(UniversiteId).get();
    }

    public Universite addUniversite(Universite c) {
        return UniversiteRepository.save(c);
    }

    public void removeUniversite(Long UniversiteId) {
        UniversiteRepository.deleteById(UniversiteId);
    }

    public Universite modifyUniversite(Universite Universite) {
        return UniversiteRepository.save(Universite);
    }
}