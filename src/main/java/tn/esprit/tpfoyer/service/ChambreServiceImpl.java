package tn.esprit.tpfoyer.service;

import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Bloc;
import tn.esprit.tpfoyer.entity.Chambre;
import tn.esprit.tpfoyer.entity.Foyer;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.ChambreRepository;
import tn.esprit.tpfoyer.repository.ReservationRepository;


import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {
    ChambreRepository chambreRepository;

    ReservationRepository reservationRepository;

    public List<Chambre> retrieveAllChambres() {
        return chambreRepository.findAll();
    }

    public Chambre retrieveChambre(Long chambreId) {
        return chambreRepository.findById(chambreId).get();
    }

    public Chambre addChambre(Chambre c) {
        return chambreRepository.save(c);
    }

    public void removeChambre(Long chambreId) {
        chambreRepository.deleteById(chambreId);
    }

    public Chambre modifyChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }



    // creation d'une chambre et une reservation en mm temps
    public Chambre createChambreWithReservation(Chambre chambre) {
        for (Reservation reservation : chambre.getReservations()) {
            reservation.setChambre(chambre);
        }
        return chambreRepository.save(chambre);
    }


    // Affectation d'une reservation non existante  à une chambre deja existante
    public Chambre reserveChambre(Long chambreId, Reservation reservation) {
        Chambre chambre = chambreRepository.findById(chambreId).orElseThrow(() -> new EntityNotFoundException("Chambre not found"));
        reservation.setChambre(chambre);
        chambre.getReservations().add(reservation);
        return chambreRepository.save(chambre);
    }

    // Désaffectation d'une reservation d'une chambre
    public void removeReservationFromChambre(String reservationId) {
        Reservation reservation = reservationRepository.findById(reservationId).orElseThrow(() -> new EntityNotFoundException("Reservation not found"));

        Chambre chambre = reservation.getChambre();
        if (chambre != null) {
            chambre.getReservations().remove(reservation);
            reservation.setChambre(null);
            chambreRepository.save(chambre);
        }
    }


}