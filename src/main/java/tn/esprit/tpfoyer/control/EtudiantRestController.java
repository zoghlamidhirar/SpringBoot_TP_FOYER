package tn.esprit.tpfoyer.control;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Etudiant;
import tn.esprit.tpfoyer.service.IEtudiantService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Etudiant")
public class EtudiantRestController {


    IEtudiantService EtudiantService;


    @GetMapping("/retrieve-all-Etudiants")
    public List<Etudiant> getEtudiants() {
        List<Etudiant> listEtudiants = EtudiantService.retrieveAllEtudiants();
        return listEtudiants;
    }

    @GetMapping("/retrieve-Etudiant/{Etudiant-id}")
    public Etudiant retrieveEtudiant(@PathVariable("Etudiant-id") Long chId) {
        Etudiant Etudiant = EtudiantService.retrieveEtudiant(chId);
        return Etudiant;
    }


    @PostMapping("/add-Etudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant c) {
        Etudiant Etudiant = EtudiantService.addEtudiant(c);
        return Etudiant;
    }


    @DeleteMapping("/remove-Etudiant/{Etudiant-id}")
    public void removeEtudiant(@PathVariable("Etudiant-id") Long chId) {
        EtudiantService.removeEtudiant(chId);
    }


    @PutMapping("/modify-Etudiant")
    public Etudiant modifyEtudiant(@RequestBody Etudiant c) {
        Etudiant Etudiant = EtudiantService.modifyEtudiant(c);
        return Etudiant;
    }

}
