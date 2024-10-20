package tn.esprit.tpfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import tn.esprit.tpfoyer.entity.Reservation;
import tn.esprit.tpfoyer.repository.ReservationRepository;


import java.util.List;

@Service
@AllArgsConstructor
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
}