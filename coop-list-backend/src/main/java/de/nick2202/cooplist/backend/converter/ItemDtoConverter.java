package de.nick2202.cooplist.backend.converter;

import de.nick2202.cooplist.backend.dto.ItemDto;
import de.nick2202.cooplist.backend.model.Item;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
public class ItemDtoConverter {

    public ItemDto toItemDto(Item item) {
        ItemDto itemDto = new ItemDto();
        itemDto.setName(item.getName());
        return itemDto;
    }

    public Item toItem(ItemDto itemDto) {
        Item item = new Item();
        item.setName(itemDto.getName());
        return item;
    }
}
