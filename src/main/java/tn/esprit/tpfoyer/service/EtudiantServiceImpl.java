package tn.esprit.tpfoyer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.repository.ChambreRepository;
import tn.esprit.tpfoyer.repository.EtudiantRepository;
import tn.esprit.tpfoyer.entity.Etudiant;

import java.util.List;

@Service
public class EtudiantServiceImpl implements IEtudiantService {

    @Autowired
    EtudiantRepository EtudiantRepository;

    @Override
    public List<Etudiant> retrieveAllEtudiants() {
        return EtudiantRepository.findAll();
    }

    @Override
    public Etudiant retrieveEtudiant(Long EtudiantId) {
        return EtudiantRepository.findById(EtudiantId).get();
    }

    @Override
    public Etudiant addEtudiant(Etudiant c) {
        return EtudiantRepository.save(c);
    }

    @Override
    public void removeEtudiant(Long EtudiantId) {
        EtudiantRepository.deleteById(EtudiantId);
    }

    @Override
    public Etudiant modifyEtudiant(Etudiant Etudiant) {
        return EtudiantRepository.save(Etudiant);
    }

}
