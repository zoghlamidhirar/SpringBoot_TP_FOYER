package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.ReservationRepository;


import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class ReservationServiceImpl implements IReservationService {
    ReservationRepository ReservationRepository;

    public List<Reservation> retrieveAllReservations() {
        return ReservationRepository.findAll();
    }

    public Reservation retrieveReservation(Long ReservationId) {
        return ReservationRepository.findById(ReservationId).get();
    }

    public Reservation addReservation(Reservation c) {
        return ReservationRepository.save(c);
    }

    public void removeReservation(Long ReservationId) {
        ReservationRepository.deleteById(ReservationId);
    }

    public Reservation modifyReservation(Reservation Reservation) {
        return ReservationRepository.save(Reservation);
    }


    @Scheduled(fixedRate = 50000) // chaque 50 secondes
    public void mettreAJourEtAfficherReservations() {

        LocalDate targetDate = LocalDate.of(2024, 1, 1);

        Date targetDateConverted = Date.from(targetDate.atStartOfDay(ZoneId.systemDefault()).toInstant());

        List<Reservation> reservations = ReservationRepository.findByAnneeUniversitaireBefore(targetDateConverted);

        for (Reservation reservation : reservations) {

            reservation.setEstValide(false);
            ReservationRepository.save(reservation);

            log.info("Reservation après mise à jour : " + reservation);
        }
    }


}