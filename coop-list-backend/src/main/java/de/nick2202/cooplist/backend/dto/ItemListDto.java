package de.nick2202.cooplist.backend.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import de.nick2202.cooplist.backend.model.ListItem;
import de.nick2202.cooplist.backend.model.User;
import lombok.Data;

import java.util.List;

@Data
public class ItemListDto {

    private Long id;
    private String name;
    @JsonManagedReference
    private List<ListItem> listItems;
    @JsonBackReference
    private List<User> users;
}
