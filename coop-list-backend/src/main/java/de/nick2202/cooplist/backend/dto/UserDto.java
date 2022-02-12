package de.nick2202.cooplist.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.nick2202.cooplist.backend.model.ItemList;
import lombok.Data;

import java.util.List;

@Data
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private Boolean isAdmin;
    @JsonIgnore
    private List<ItemList> itemLists;
}
