package de.nick2202.cooplist.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.nick2202.cooplist.backend.model.ListItem;
import de.nick2202.cooplist.backend.model.User;
import lombok.Data;

import java.util.List;

@Data
public class ItemListDto {

    private Long id;
    private String name;
    @JsonIgnore
    private List<ListItem> listItems;
    @JsonIgnore
    private List<User> users;
}
