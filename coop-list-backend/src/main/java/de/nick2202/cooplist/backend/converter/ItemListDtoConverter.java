package de.nick2202.cooplist.backend.converter;

import de.nick2202.cooplist.backend.dto.ItemListDto;
import de.nick2202.cooplist.backend.model.ItemList;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ItemListDtoConverter {

    public ItemListDto toItemListDto(ItemList itemList) {
        ItemListDto itemListDto = new ItemListDto();
        itemListDto.setName(itemList.getName());
        itemListDto.setListItems(itemList.getListItems());
        itemListDto.setUsers(itemList.getUsers());
        return itemListDto;
    }

    public ItemList toItemList(ItemListDto itemListDto) {
        ItemList itemList = new ItemList();
        itemList.setName(itemListDto.getName());
        itemList.setListItems(itemListDto.getListItems());
        itemList.setUsers(itemListDto.getUsers());
        return itemList;
    }

}
