package yassine.tn.yassine_ski.Entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
@NoArgsConstructor
public class Piste implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long numPiste;

    private String nomPiste;

    @Enumerated(EnumType.STRING)
    private Couleur couleur;

    private int longueur;

    private int pente;

    @JsonIgnore
    @ManyToMany(mappedBy = "pistes")
    private List<Skieur> skieurs;
}
