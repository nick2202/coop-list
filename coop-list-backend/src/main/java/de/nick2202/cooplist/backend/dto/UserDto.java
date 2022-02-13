package de.nick2202.cooplist.backend.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import de.nick2202.cooplist.backend.model.ItemList;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.util.List;

@Data
@NoArgsConstructor
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

    @GeneratePojoBuilder
    public UserDto(Long id, String firstName, String lastName, String userName, String email, String password, Boolean isAdmin, List<ItemList> itemLists) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.email = email;
        this.password = password;
        this.isAdmin = isAdmin;
        this.itemLists = itemLists;
    }
}
