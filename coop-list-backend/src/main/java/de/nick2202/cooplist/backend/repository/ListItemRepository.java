package de.nick2202.cooplist.backend.repository;

import de.nick2202.cooplist.backend.model.Item;
import de.nick2202.cooplist.backend.model.ItemList;
import de.nick2202.cooplist.backend.model.ListItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ListItemRepository extends JpaRepository<ListItem, Long> {

    List<ListItem> findAll();

    Optional<ListItem> findFirstByItem(Item item);

    List<ListItem> findAllByItemListAndItem(ItemList itemList, Item item);
}