package de.nick2202.cooplist.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Produkt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prod_id")
    private Long id;

    @NotNull
    private String name;

    private String preis;

    private String menge;

    private String produktgruppe;

    private String laden;

    @OneToMany(mappedBy = "produkt")
    private List<BenoetigtesProdukt> benoetigtesProduktListe;

}
