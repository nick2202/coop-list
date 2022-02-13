package de.nick2202.cooplist.backend.converter;

import de.nick2202.cooplist.backend.dto.ItemListDto;
import de.nick2202.cooplist.backend.dto.ListItemDto;
import de.nick2202.cooplist.backend.dto.UserDto;
import de.nick2202.cooplist.backend.model.ItemList;
import de.nick2202.cooplist.backend.model.ListItem;
import de.nick2202.cooplist.backend.model.User;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class ItemListDtoConverter {

    private final ListItemDtoConverter listItemDtoConverter;
    private final UserDtoConverter userDtoConverter;

    public ItemListDto toItemListDto(ItemList itemList) {
        ItemListDto itemListDto = new ItemListDto();
        itemListDto.setName(itemList.getName());

        List<ListItemDto> listItemDtos = new ArrayList<>();
        for (ListItem listItem : itemList.getListItems()) {
            listItemDtos.add(listItemDtoConverter.toListItemDto(listItem));
        }

        itemListDto.setListItems(listItemDtos);

        List<UserDto> userDtos = new ArrayList<>();
        for (User user : itemList.getUsers()) {
            userDtos.add(userDtoConverter.toUserDto(user));
        }
        itemListDto.setUsers(userDtos);
        return itemListDto;
    }

    public ItemList toitemList(ItemListDto itemListDto) {
        ItemList itemList = new ItemList();
        itemList.setName(itemListDto.getName());

        List<ListItem> listItems = new ArrayList<>();
        for (ListItemDto listItemDto : itemListDto.getListItems()) {
            listItems.add(listItemDtoConverter.toListItem(listItemDto));
        }
        itemList.setListItems(listItems);

        List<User> users = new ArrayList<>();
        for (UserDto userDto : itemListDto.getUsers()) {
            users.add(userDtoConverter.toUser(userDto));
        }
        itemList.setUsers(users);
        return itemList;
    }

}
