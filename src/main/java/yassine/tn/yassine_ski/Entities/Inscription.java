package yassine.tn.yassine_ski.Entities;


import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
//import yassine.tn.yassine_ski.Entities.Cours;
//import yassine.tn.yassine_ski.Entities.Skieur;

import java.io.*;

@Entity
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
//@Table(name = "inscription")
public class Inscription implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long numInscription;

    private int numSemaine;

    @ManyToOne
    @JoinColumn(name = "num_skieur")
    @JsonBackReference
    private Skieur skieur;


    @ManyToOne
    private Cours cours;
}