package de.nick2202.cooplist.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class BenoetigtesProdukt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "benoet_prod_id")
    private Long id;

    @NotNull
    @ManyToOne
    private Wg wg;

    @NotNull
    @ManyToOne
    private Produkt produkt;

    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp eintragungszeitpunkt;

    @UpdateTimestamp
    private Timestamp kaufzeitpunkt = null;

    private boolean gekauft = false;

    public BenoetigtesProdukt(@NotNull Produkt produkt, @NotNull Wg wg) {
        this.produkt = produkt;
        this.wg = wg;
    }
}
