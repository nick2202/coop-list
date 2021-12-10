package de.nick2202.cooplist.backend.repository;

import de.nick2202.cooplist.backend.model.Wg;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WgRepository extends JpaRepository<Wg, Long> {

    Optional<Wg> findById(Long id);
}
