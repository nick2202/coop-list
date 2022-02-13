package de.nick2202.cooplist.backend.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.nick2202.cooplist.backend.model.ListItem;
import lombok.Data;

import java.util.List;

@Data
public class ItemDto {

    private Long id;
    private String name;
    @JsonManagedReference
    private List<ListItem> listItems;
}
