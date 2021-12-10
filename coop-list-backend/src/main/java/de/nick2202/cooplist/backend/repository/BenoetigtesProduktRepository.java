package de.nick2202.cooplist.backend.repository;

import de.nick2202.cooplist.backend.model.BenoetigtesProdukt;
import de.nick2202.cooplist.backend.model.Produkt;
import de.nick2202.cooplist.backend.model.Wg;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface BenoetigtesProduktRepository extends JpaRepository<BenoetigtesProdukt, Long> {

    @Query(nativeQuery = true,
            value = "SELECT * FROM BenoetigtesProdukt u " +
                    "WHERE u.gekauft = false " +
                    "AND u.produkt = ?1 " +
                    "AND u.wg = ?2 " +
                    "ORDER BY u.eintragungszeitpunkt ASC LIMIT 1")
    Optional<BenoetigtesProdukt> findFirstBenoetigtesProdukt(Produkt produkt, Wg wg);

}