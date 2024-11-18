package tn.esprit.tpfoyer.service;

import tn.esprit.tpfoyer.entity.Reservation;
import java.util.List;

public interface IReservationService {
    public List<Reservation> retrieveAllReservations();
    public Reservation retrieveReservation(Long ReservationId);
    public Reservation addReservation(Reservation c);
    public void removeReservation(Long ReservationId);
    public Reservation modifyReservation(Reservation Reservation);

    public void mettreAJourEtAfficherReservations();

// Later on ...
// Here we will add later methods calling keywords and methods calling JPQL

}