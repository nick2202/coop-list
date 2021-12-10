package de.nick2202.cooplist.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Bewohner {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "bewo_id")
    private Long id;

    @NotNull
    private String vorname;

    @NotNull
    private String nachname;

    @Column(unique = true)
    @NotNull
    private String benutzername;

    @NotNull
    private String password;

    private Boolean isAdmin = false;

    @ManyToOne
    private Wg wg;

}
