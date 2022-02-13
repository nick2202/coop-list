package de.nick2202.cooplist.backend.controller;

import de.nick2202.cooplist.backend.converter.ItemListDtoConverter;
import de.nick2202.cooplist.backend.converter.ListItemDtoConverter;
import de.nick2202.cooplist.backend.dto.ItemListDto;
import de.nick2202.cooplist.backend.dto.ListItemDto;
import de.nick2202.cooplist.backend.model.ItemList;
import de.nick2202.cooplist.backend.service.ItemListService;
import de.nick2202.cooplist.backend.service.ListItemService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/{userId}/lists")
@AllArgsConstructor
public class ItemListController {

    private final ItemListDtoConverter itemListDtoConverter;
    private final ListItemDtoConverter listItemDtoConverter;
    private final ItemListService itemListService;
    private final ListItemService listItemService;

    @GetMapping
    public List<ItemList> getAllLists(@PathVariable Long userId) {
        return itemListService.getItemLists(userId);
    }

    @GetMapping(value = "/{listId}")
    public ItemList getList(@PathVariable Long userId, @PathVariable Long listId) {
        return itemListService.getItemList(userId, listId);
    }

    @DeleteMapping(value = "/{listId}")
    public void deleteList(@PathVariable Long userId, @PathVariable Long listId) {
        itemListService.deleteItemList(itemListService.getItemList(userId, listId));
    }

    @PostMapping
    public ItemListDto addList(@PathVariable Long userId, @RequestParam String name) {
        return itemListDtoConverter.toItemListDto(itemListService.addItemList(name, userId));
    }

    @PostMapping(value = "/{listId}/addUser")
    public ItemListDto addUser(@PathVariable Long userId, @PathVariable Long listId, @RequestParam Long newUserId) {
        return itemListDtoConverter.toItemListDto(itemListService.addUserToList(userId, listId, newUserId));
    }

    @PostMapping(value = "/{listId}/addListItem")
    public ListItemDto addListItem(@PathVariable Long listId, @RequestParam String name) {
        return listItemDtoConverter.toListItemDto(listItemService.addListItem(listId, name));
    }

    @PostMapping(value = "/{listId}/checkListItem")
    public ListItemDto checkListItem(@PathVariable Long listId, @RequestParam String name) {
        return listItemDtoConverter.toListItemDto(listItemService.checkListItem(listId, name));
    }

}
