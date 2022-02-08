package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.model.Item;
import de.nick2202.cooplist.backend.repository.ItemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ItemService {

    private final ItemRepository repository;

    public Optional<Item> getItem(Long id) {
        return repository.findById(id);
    }

    public List<Item> getItemsByName(String name) {
        return repository.findAllByName(name);
    }

    public Item addItem(Item item) {
        return repository.save(item);
    }

}
