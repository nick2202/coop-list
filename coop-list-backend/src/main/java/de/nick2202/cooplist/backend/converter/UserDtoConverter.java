package de.nick2202.cooplist.backend.converter;

import de.nick2202.cooplist.backend.dto.UserDto;
import de.nick2202.cooplist.backend.model.User;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserDtoConverter {

    private final BCryptPasswordEncoder encoder;

    public UserDto toUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setUserName(user.getUserName());
        userDto.setEmail(user.getEmail());
        userDto.setFirstName(user.getFirstName());
        userDto.setLastName(user.getLastName());
        userDto.setItemLists(user.getItemLists());
        return userDto;
    }

    public User toUser(UserDto userDto) {
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setEmail(userDto.getEmail());
        user.setPassword(encoder.encode(userDto.getPassword()));
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        user.setItemLists(userDto.getItemLists());
        return user;
    }
}
