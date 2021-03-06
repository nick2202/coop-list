package de.nick2202.cooplist.backend.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import de.nick2202.cooplist.backend.model.Item;
import de.nick2202.cooplist.backend.model.ItemList;
import lombok.Data;

@Data
public class ListItemDto {

    private Long id;
    @JsonBackReference
    private Item item;
    @JsonBackReference
    private ItemList itemList;

}
