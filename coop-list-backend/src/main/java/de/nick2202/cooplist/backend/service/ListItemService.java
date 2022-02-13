package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.exceptions.ResourceNotFoundException;
import de.nick2202.cooplist.backend.model.Item;
import de.nick2202.cooplist.backend.model.ItemList;
import de.nick2202.cooplist.backend.model.ListItem;
import de.nick2202.cooplist.backend.repository.ItemListRepository;
import de.nick2202.cooplist.backend.repository.ItemRepository;
import de.nick2202.cooplist.backend.repository.ListItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ListItemService {

    private final ListItemRepository listItemRepository;
    private final ItemRepository itemRepository;
    private final ItemListRepository itemListRepository;

    /**
     * @param listId   Id of the {@link ItemList} to add the {@link ListItem} to
     * @param itemName name of the item
     * @return {@link ListItem}
     */
    public ListItem addListItem(Long listId, String itemName) {
        return listItemRepository.save(
                new ListItem(
                        itemRepository
                                .findFirstByName(itemName)
                                .orElseGet(() -> itemRepository.save(new Item(itemName))),
                        itemListRepository
                                .findById(listId)
                                .orElseThrow(() -> new ResourceNotFoundException("ItemList not found."))));
    }

    /**
     * Get the first {@link ListItem} of an {@link ItemList} (that is not checked).
     *
     * @param listId   Id of the {@link ItemList} the item is part of
     * @param itemName name of the item
     * @return {@link ListItem}
     */
    public ListItem getListItem(Long listId, String itemName) {
        return listItemRepository
                .findAllByItemListAndItem(itemListRepository.findById(listId).orElseThrow(ResourceNotFoundException::new),
                        itemRepository.findFirstByName(itemName).orElseThrow(ResourceNotFoundException::new))
                .stream()
                .filter(listItem -> !listItem.isChecked())
                .findFirst()
                .orElseThrow(ResourceNotFoundException::new);
    }

    /**
     * Mark the first {@link ListItem} of an {@link ItemList} as checked (i.e. done).
     *
     * @param listId   Id of the {@link ItemList} the item is part of
     * @param itemName name of the item
     * @return {@link ListItem}
     */
    // functional programming example
    public ListItem checkListItem(Long listId, String itemName) {
        return listItemRepository.save(
                listItemRepository
                        .findAllByItemListAndItem(itemListRepository.findById(listId).orElseThrow(ResourceNotFoundException::new),
                                itemRepository.findFirstByName(itemName).orElseThrow(ResourceNotFoundException::new))
                        .stream()
                        .filter(listItem -> !listItem.isChecked())
                        .findFirst()
                        .map(ListItem::check)
                        .orElseThrow(ResourceNotFoundException::new));
    }

}
