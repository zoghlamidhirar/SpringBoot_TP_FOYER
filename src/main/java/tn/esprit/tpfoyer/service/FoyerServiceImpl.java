package tn.esprit.tpfoyer.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.repository.BlocRepository;
import tn.esprit.tpfoyer.repository.FoyerRepository;


import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class FoyerServiceImpl implements IFoyerService {
    FoyerRepository FoyerRepository;

    BlocRepository BlocRepository;


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

    // creation d'un bloc et un foyer en mm temps
    public Foyer createFoyerWithBlocs(Foyer foyer) {
        for (Bloc bloc : foyer.getBlocs()) {
            bloc.setFoyer(foyer);
        }
        return FoyerRepository.save(foyer);
    }

    // Affectation d'un Bloc à un Foyer deja existant
    public Bloc assignBlocToFoyer(Long blocId, Long foyerId) {
        Bloc bloc = BlocRepository.findById(blocId).orElseThrow(() -> new EntityNotFoundException("Bloc not found"));
        Foyer foyer = FoyerRepository.findById(foyerId).orElseThrow(() -> new EntityNotFoundException("Foyer not found"));
        bloc.setFoyer(foyer);
        return BlocRepository.save(bloc);
    }

    // Désaffectation d'un Bloc de son Foyer
    public Bloc removeBlocFromFoyer(Long blocId) {
        Bloc bloc = BlocRepository.findById(blocId).orElseThrow(() -> new EntityNotFoundException("Bloc not found"));
        bloc.setFoyer(null);
        return BlocRepository.save(bloc);
    }
}