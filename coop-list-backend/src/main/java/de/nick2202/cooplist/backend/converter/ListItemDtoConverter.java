package de.nick2202.cooplist.backend.converter;

import de.nick2202.cooplist.backend.dto.ListItemDto;
import de.nick2202.cooplist.backend.model.ListItem;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ListItemDtoConverter {

    public ListItemDto toListItemDto(ListItem listItem) {
        ListItemDto listItemDto = new ListItemDto();
        listItemDto.setItem(listItem.getItem());
        listItemDto.setItemList(listItem.getItemList());
        return listItemDto;
    }

    public ListItem toListItem(ListItemDto listItemDto) {
        ListItem listItem = new ListItem();
        listItem.setItem(listItemDto.getItem());
        listItem.setItemList(listItemDto.getItemList());
        return listItem;
    }
}
