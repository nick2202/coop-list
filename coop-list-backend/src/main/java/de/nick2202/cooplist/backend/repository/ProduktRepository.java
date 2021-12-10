package de.nick2202.cooplist.backend.repository;

import de.nick2202.cooplist.backend.model.Produkt;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProduktRepository extends JpaRepository<Produkt, Long> {

    Optional<Produkt> findById(Long id);

    Optional<Produkt> findByName(String name);

    List<Produkt> findAllByName(String name);
}
