package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.exceptions.ResourceNotFoundException;
import de.nick2202.cooplist.backend.model.Item;
import de.nick2202.cooplist.backend.model.ListItem;
import de.nick2202.cooplist.backend.model.ItemGroup;
import de.nick2202.cooplist.backend.repository.ListItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ListItemService {

    private final ListItemRepository repository;

    public ListItem addListItem(ListItem listItem) {
        return repository.save(new ListItem(listItem.getItem(), listItem.getItemGroup()));

    }

    public ListItem checkListItem(Item item, ItemGroup itemGroup) {
        Optional<ListItem> listItemOptional = repository
                .findAllByItemAndItemGroup(item, itemGroup)
                .stream()
                .findFirst();
        if (listItemOptional.isPresent()) {
            ListItem listItem = listItemOptional.get();
            listItem.setChecked(true);
            return repository.save(listItem);
        } else
            throw new ResourceNotFoundException("Item not on list.\n" +
                    "Please refresh the page");

    }
}
