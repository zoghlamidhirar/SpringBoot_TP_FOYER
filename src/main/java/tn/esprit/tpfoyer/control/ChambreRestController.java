package tn.esprit.tpfoyer.control;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.service.IChambreService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/chambre")
public class ChambreRestController {


    IChambreService chambreService;


    @GetMapping("/retrieve-all-chambres")
    public List<Chambre> getChambres() {
        List<Chambre> listChambres = chambreService.retrieveAllChambres();
        return listChambres;
    }

    @GetMapping("/retrieve-chambre/{chambre-id}")
    public Chambre retrieveChambre(@PathVariable("chambre-id") Long chId) {
        Chambre chambre = chambreService.retrieveChambre(chId);
        return chambre;
    }


    @PostMapping("/add-chambre")
    public Chambre addChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.addChambre(c);
        return chambre;
    }


    @DeleteMapping("/remove-chambre/{chambre-id}")
    public void removeChambre(@PathVariable("chambre-id") Long chId) {
        chambreService.removeChambre(chId);
    }


    @PutMapping("/modify-chambre")
    public Chambre modifyChambre(@RequestBody Chambre c) {
        Chambre chambre = chambreService.modifyChambre(c);
        return chambre;
    }

    @PostMapping("/createChambreWithReservation")
    public Chambre createChambreWithReservation(@RequestBody Chambre chambre) {
        Chambre createdChambre = chambreService.createChambreWithReservation(chambre);
        return createdChambre;
    }

    @PostMapping("/reserveChambre")
    public Chambre reserveChambre(@RequestParam Long chambreId, @RequestBody Reservation reservation) {
        Chambre updatedChambre = chambreService.reserveChambre(chambreId, reservation);
        return updatedChambre;
    }

    @PutMapping("/removeReservationFromChambre")
    public void removeReservationFromChambre(@RequestParam String reservationId) {
         chambreService.removeReservationFromChambre(reservationId);

    }



}