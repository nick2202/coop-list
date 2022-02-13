package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.exceptions.PatternMismatchException;
import de.nick2202.cooplist.backend.exceptions.ResourceNotFoundException;
import de.nick2202.cooplist.backend.exceptions.ResourceNotFoundException.Message;
import de.nick2202.cooplist.backend.model.Item;
import de.nick2202.cooplist.backend.model.ItemList;
import de.nick2202.cooplist.backend.model.ListItem;
import de.nick2202.cooplist.backend.repository.ItemListRepository;
import de.nick2202.cooplist.backend.repository.ItemRepository;
import de.nick2202.cooplist.backend.repository.ListItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.regex.Pattern;

@Service
@AllArgsConstructor
public class ListItemService {

    private final ListItemRepository listItemRepository;
    private final ItemRepository itemRepository;
    private final ItemListRepository itemListRepository;

    /**
     * Add {@link ListItem} to {@link ItemList}.
     *
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
                                .orElseThrow(() -> new ResourceNotFoundException(Message.ITEM_LIST_NOT_FOUND))));
    }

    /**
     * Verify {@link ListItem} by RegEx Pattern and if valid add it to {@link ItemList}.
     *
     * @param listId   Id of the {@link ItemList} to add the {@link ListItem} to
     * @param itemName name of the item
     * @param pattern  RegEx pattern to validate the itemName against
     * @return {@link ListItem}
     */
    public ListItem addVerifiedListItem(Long listId, String itemName, Pattern pattern) throws PatternMismatchException {
        // RegEx that matches any word, digit or whitespace (no special characters)
        Pattern examplePattern = Pattern.compile("[\\w ]");
        pattern = pattern == null ? examplePattern : pattern;
        if (pattern.matcher(itemName).matches()) {
            return listItemRepository.save(
                    new ListItem(
                            itemRepository
                                    .findFirstByName(itemName)
                                    .orElseGet(() -> itemRepository.save(new Item(itemName))),
                            itemListRepository
                                    .findById(listId)
                                    .orElseThrow(() -> new ResourceNotFoundException(Message.ITEM_LIST_NOT_FOUND))));
        } else {
            throw new PatternMismatchException();
        }
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
                .findAllByItemListAndItem(itemListRepository.findById(listId).orElseThrow(() -> new ResourceNotFoundException(Message.ITEM_LIST_NOT_FOUND)),
                        itemRepository.findFirstByName(itemName).orElseThrow(() -> new ResourceNotFoundException(Message.ITEM_NOT_FOUND)))
                .stream()
                .filter(listItem -> !listItem.isChecked())
                .findFirst()
                .orElseThrow(() -> new ResourceNotFoundException(Message.LIST_ITEM_NOT_FOUND));
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
                        .findAllByItemListAndItem(itemListRepository.findById(listId).orElseThrow(() -> new ResourceNotFoundException(Message.ITEM_LIST_NOT_FOUND)),
                                itemRepository.findFirstByName(itemName).orElseThrow(() -> new ResourceNotFoundException(Message.ITEM_NOT_FOUND)))
                        .stream()
                        .filter(listItem -> !listItem.isChecked())
                        .findFirst()
                        .map(ListItem::check)
                        .orElseThrow(() -> new ResourceNotFoundException(Message.LIST_ITEM_NOT_FOUND)));
    }

}
