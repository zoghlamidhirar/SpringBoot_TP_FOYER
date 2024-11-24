package tn.esprit.tpfoyer.control;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.service.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Foyer")
public class FoyerRestController {


    IFoyerService FoyerService;


    @GetMapping("/retrieve-all-Foyers")
    public List<Foyer> getFoyers() {
        List<Foyer> listFoyers = FoyerService.retrieveAllFoyers();
        return listFoyers;
    }

    @GetMapping("/retrieve-Foyer/{Foyer-id}")
    public Foyer retrieveFoyer(@PathVariable("Foyer-id") Long chId) {
        Foyer Foyer = FoyerService.retrieveFoyer(chId);
        return Foyer;
    }


    @PostMapping("/add-Foyer")
    public Foyer addFoyer(@RequestBody Foyer c) {
        Foyer Foyer = FoyerService.addFoyer(c);
        return Foyer;
    }


    @DeleteMapping("/remove-Foyer/{Foyer-id}")
    public void removeFoyer(@PathVariable("Foyer-id") Long chId) {
        FoyerService.removeFoyer(chId);
    }


    @PutMapping("/modify-Foyer")
    public Foyer modifyFoyer(@RequestBody Foyer c) {
        Foyer Foyer = FoyerService.modifyFoyer(c);
        return Foyer;
    }

    // creation d'un bloc et un foyer en mm temps
    @PostMapping("/createFoyerWithBlocs")
    public ResponseEntity<Foyer> createFoyerWithBlocs(@RequestBody Foyer foyer) {
        Foyer createdFoyer = FoyerService.createFoyerWithBlocs(foyer);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdFoyer);
    }

    // Affectation d'un Bloc à un Foyer deja existant
    @PutMapping("/assignExistingBlocToAnExistingFoyer")
    public void assignBlocToFoyer(@RequestParam Long blocId, @RequestParam Long foyerId) {
        FoyerService.assignBlocToFoyer(blocId, foyerId);

    }

    //  Désaffectation d'un Bloc de son Foyer
    @PutMapping("/removeBloc")
    public void removeBlocFromFoyer(@RequestParam Long blocId) {
        FoyerService.removeBlocFromFoyer(blocId);

    }

}