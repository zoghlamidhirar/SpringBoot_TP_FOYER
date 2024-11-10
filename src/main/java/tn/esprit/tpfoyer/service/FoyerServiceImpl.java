package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.FoyerRepository;


import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    FoyerRepository FoyerRepository;


    @Scheduled(fixedRate = 60000)
    public List<Foyer> retrieveAllFoyers() {

        List<Foyer> foyers = FoyerRepository.findAll();
        for (Foyer f: foyers) {
            log.info("Foyer :" + f);
        }

        return foyers;
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