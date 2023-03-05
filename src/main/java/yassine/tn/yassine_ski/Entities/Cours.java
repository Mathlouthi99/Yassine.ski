package yassine.tn.yassine_ski.Entities;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter @Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "cours")
public class Cours implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numCours;

    private int niveau;

    @Enumerated(EnumType.STRING)
    private TypeCours typeCours;

    @Enumerated(EnumType.STRING)
    private Support support;

    private float prix;

    private int creneau;

    @OneToMany(mappedBy = "cours")
    private List<Inscription> inscriptions;

    @ManyToOne
    @JoinColumn(name = "moniteur_id")
    private Moniteur moniteur;



}
