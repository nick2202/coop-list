package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.exceptions.ResourceNotFoundException;
import de.nick2202.cooplist.backend.model.Item;
import de.nick2202.cooplist.backend.model.ItemList;
import de.nick2202.cooplist.backend.model.ListItem;
import de.nick2202.cooplist.backend.repository.ItemRepository;
import de.nick2202.cooplist.backend.repository.ListItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class ListItemService {

    private final ListItemRepository listItemRepository;
    private final ItemRepository itemRepository;

    public ListItem addListItem(ListItem listItem) {
        return listItemRepository.save(
                new ListItem(itemRepository.findByName(listItem.getItem().getName()).orElse(listItem.getItem()),
                        listItem.getItemList()));
    }


    public ListItem checkListItem(Item item, ItemList itemList) {
        Optional<ListItem> listItemOptional = listItemRepository
                .findAllByItemAndItemList(item, itemList)
                .stream()
                .findFirst();
        if (listItemOptional.isPresent()) {
            ListItem listItem = listItemOptional.get();
            listItem.setChecked(true);
            return listItemRepository.save(listItem);
        } else
            throw new ResourceNotFoundException("Item not on list.\n" +
                    "Please refresh the page");

    }
}
