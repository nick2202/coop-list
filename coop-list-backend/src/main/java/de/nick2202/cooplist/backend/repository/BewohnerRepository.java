package de.nick2202.cooplist.backend.repository;

import de.nick2202.cooplist.backend.model.Bewohner;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BewohnerRepository extends JpaRepository<Bewohner, Long> {

    Optional<Bewohner> findById(Long id);

    Optional<Bewohner> findByBenutzername(String benutzername);
}
