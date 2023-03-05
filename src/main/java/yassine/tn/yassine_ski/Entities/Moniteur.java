package yassine.tn.yassine_ski.Entities;

import javax.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Entity
@ToString
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
//@Table(name = "moniteurs")
public class Moniteur implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long numMoniteur;
    private String nomM;
    private String prenomM;
    private LocalDate dateRecru;

    @OneToMany
    private List<Cours> cours;


    public void addCours(Cours cours) {
        this.cours.add(cours);
        cours.setMoniteur(this);
    }
}