package de.nick2202.cooplist.backend.repository;

import de.nick2202.cooplist.backend.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface GroupRepository extends JpaRepository<Group, Long> {

}
