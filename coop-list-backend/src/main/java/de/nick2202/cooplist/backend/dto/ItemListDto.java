package de.nick2202.cooplist.backend.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;

import java.util.List;

@Data
public class ItemListDto {

    private Long id;
    private String name;
    @JsonManagedReference
    private List<ListItemDto> listItems;
    @JsonBackReference
    private List<UserDto> users;
}
