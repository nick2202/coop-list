package de.nick2202.cooplist.backend.repository;

import de.nick2202.cooplist.backend.model.ItemList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemListRepository extends JpaRepository<ItemList, Long> {

}
