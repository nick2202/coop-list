package de.nick2202.cooplist.backend.dto;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.karneim.pojobuilder.GeneratePojoBuilder;

import java.util.List;

@Data
@NoArgsConstructor
@GeneratePojoBuilder
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String userName;
    private String email;
    private String password;
    private Boolean isAdmin;
    @JsonManagedReference
    private List<ItemListDto> itemLists;

}
