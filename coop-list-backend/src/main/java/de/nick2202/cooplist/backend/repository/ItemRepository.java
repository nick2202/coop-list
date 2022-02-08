package de.nick2202.cooplist.backend.repository;

import de.nick2202.cooplist.backend.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ItemRepository extends JpaRepository<Item, Long> {

    Optional<Item> findByName(String name);

    List<Item> findAllByName(String name);
}
