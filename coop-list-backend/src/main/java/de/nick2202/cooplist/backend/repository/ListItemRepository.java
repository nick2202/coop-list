package de.nick2202.cooplist.backend.repository;

import de.nick2202.cooplist.backend.model.ListItem;
import de.nick2202.cooplist.backend.model.Item;
import de.nick2202.cooplist.backend.model.ItemGroup;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ListItemRepository extends JpaRepository<ListItem, Long> {

    List<ListItem> findAll();

    Optional<ListItem> findAllByItemAndItemGroup(Item item, ItemGroup itemGroup);
}