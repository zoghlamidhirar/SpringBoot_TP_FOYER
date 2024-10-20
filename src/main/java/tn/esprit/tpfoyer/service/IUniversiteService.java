package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Universite;
import java.util.List;

public interface IUniversiteService {
    public List<Universite> retrieveAllUniversites();
    public Universite retrieveUniversite(Long UniversiteId);
    public Universite addUniversite(Universite c);
    public void removeUniversite(Long UniversiteId);
    public Universite modifyUniversite(Universite Universite);

// Later on ...
// Here we will add later methods calling keywords and methods calling JPQL

}