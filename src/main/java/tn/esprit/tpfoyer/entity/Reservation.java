package tn.esprit.tpfoyer.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Reservation {

    @Id
    private String idReservation;

    private Date anneeUniversitaire;
    private boolean estValide;

    @ManyToOne
    @ToString.Exclude
    @JoinColumn(name = "chambre_id")
    private Chambre chambre;

    @ManyToMany(cascade = CascadeType.ALL)
    @ToString.Exclude
    private List<Etudiant> etudiants;


}
