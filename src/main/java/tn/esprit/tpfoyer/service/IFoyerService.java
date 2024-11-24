package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import java.util.List;

public interface IFoyerService {
    public List<Foyer> retrieveAllFoyers();
    public Foyer retrieveFoyer(Long FoyerId);
    public Foyer addFoyer(Foyer c);
    public void removeFoyer(Long FoyerId);
    public Foyer modifyFoyer(Foyer Foyer);

    public Foyer createFoyerWithBlocs(Foyer foyer);

    public void assignBlocToFoyer(Long blocId, Long foyerId);

    public void removeBlocFromFoyer(Long blocId);
// Later on ...
// Here we will add later methods calling keywords and methods calling JPQL

}