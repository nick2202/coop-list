package de.nick2202.cooplist.backend.repository;

import de.nick2202.cooplist.backend.model.ListItem;
import de.nick2202.cooplist.backend.model.Item;
import de.nick2202.cooplist.backend.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface ListItemRepository extends JpaRepository<ListItem, Long> {

    Optional<ListItem> findFirstListItem(Item item, Group group);

}