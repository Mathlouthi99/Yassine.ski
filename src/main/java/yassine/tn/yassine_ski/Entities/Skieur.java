package yassine.tn.yassine_ski.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor

public class Skieur implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numSkieur;

    private String nomSkieur;

    private String prenomSkieur;

    @JsonIgnore
    @ManyToMany
    private List<Piste> pistes;

    @ManyToOne
    private Cours cours;



    public Skieur() {
        this.cours = new Cours(); // initialize to default value
    }

    @OneToOne(mappedBy = "skieur", cascade = CascadeType.ALL)
    @JsonIgnore
    private Abonnement abonnement;

    @OneToMany(mappedBy = "skieur")
    @JsonManagedReference
    private List<Inscription> inscriptions;



    public Cours getCours() {
        return this.cours;
    }
}
