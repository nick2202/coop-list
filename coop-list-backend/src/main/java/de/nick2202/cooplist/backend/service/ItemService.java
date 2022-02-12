package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.exceptions.ResourceNotFoundException;
import de.nick2202.cooplist.backend.model.Item;
import de.nick2202.cooplist.backend.model.ListItem;
import de.nick2202.cooplist.backend.repository.ItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    /**
     * Get item by Id.
     *
     * @param id Id of the {@link Item}
     * @return {@link Item}
     */
    public Item getItem(Long id) {
        return repository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * Get item by name.
     *
     * @param name name of the {@link Item}
     * @return {@link Item}
     */
    public Item getItem(String name) {
        return repository.findFirstByName(name).orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * Add an {@link Item}. An {@link Item} is created automatically when adding a {@link ListItem} of which no {@link Item} exists yet).
     *
     * @param item {@link Item} to add.
     * @return {@link Item}
     */
    public Item addItem(Item item) {
        return repository.save(item);
    }

}
