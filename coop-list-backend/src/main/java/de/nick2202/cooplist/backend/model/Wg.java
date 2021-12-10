package de.nick2202.cooplist.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Wg {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "wg_id")
    private Long id;

    @OneToMany(mappedBy = "wg")
    private List<Bewohner> bewohnerListe;

    @OneToMany(mappedBy = "wg")
    private List<BenoetigtesProdukt> benoetigtesProduktListe;

    @Column(unique = true)
    private String name;

    private String strasse;

    private int hausnummer;

    private int plz;

    private String ort;


}
