package yassine.tn.yassine_ski.Entities;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.*;

import lombok.*;
//import yassine.tn.yassine_ski.Entities.Skieur;
//import yassine.tn.yassine_ski.Entities.TypeAbonnement;

@Entity
@Getter @Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Abonnement implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numAbon;

    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Float prixAbon;

    @Enumerated(EnumType.STRING)
    private TypeAbonnement typeAbon;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "skieur_id")
    private Skieur skieur;

}
