package de.nick2202.cooplist.backend.converter;

import de.nick2202.cooplist.backend.dto.ItemListDto;
import de.nick2202.cooplist.backend.dto.UserDto;
import de.nick2202.cooplist.backend.dto.UserDtoBuilder;
import de.nick2202.cooplist.backend.model.ItemList;
import de.nick2202.cooplist.backend.model.User;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDtoConverter {

    private final ItemListDtoConverter itemListDtoConverter;
    private final BCryptPasswordEncoder encoder;

    public UserDtoConverter(@Lazy ItemListDtoConverter itemListDtoConverter, BCryptPasswordEncoder encoder) {
        this.itemListDtoConverter = itemListDtoConverter;
        this.encoder = encoder;
    }

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());

        List<ItemListDto> itemListDtos = new ArrayList<>();
        for (ItemList itemList : user.getItemLists()) {
            itemListDtos.add(itemListDtoConverter.toItemListDto(itemList));
        }
        userDto.setItemLists(itemListDtos);
        return userDto;
    }

    // DSL example: Builder
    public UserDto buildUserDto(User user) {
        return new UserDtoBuilder()
                .withId(user.getId())
                .withUserName(user.getUserName())
                .withEmail(user.getEmail())
                .withFirstName(user.getFirstName())
                .withLastName(user.getLastName())
                .withPassword(user.getPassword())
                .withItemLists(new ArrayList<>())
                .build();
    }

    public User toUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());

        List<ItemList> itemLists = new ArrayList<>();
        for (ItemListDto itemListDto : userDto.getItemLists()) {
            itemLists.add(itemListDtoConverter.toitemList(itemListDto));
        }
        user.setItemLists(itemLists);
        return user;
    }

    // DSL example: Builder
    public UserDto buildUser(UserDto userDto) {
        return new UserDtoBuilder()
                .withId(userDto.getId())
                .withUserName(userDto.getUserName())
                .withEmail(userDto.getEmail())
                .withFirstName(userDto.getFirstName())
                .withLastName(userDto.getLastName())
                .withPassword(userDto.getPassword())
                .withItemLists(new ArrayList<>())
                .build();
    }

}
