package de.nick2202.cooplist.backend.controller;

import de.nick2202.cooplist.backend.converter.UserDtoConverter;
import de.nick2202.cooplist.backend.dto.UserDto;
import de.nick2202.cooplist.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/user")
@AllArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserDtoConverter userDtoConverter;


    @PostMapping(value = "/register")
    public UserDto registerUser(@RequestBody UserDto userDto) {
        return userDtoConverter.toUserDto(userService.registerUser(userDtoConverter.toUser(userDto)));
    }

    @DeleteMapping(value = "/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping(value = "/{userId}")
    public UserDto getUser(@PathVariable Long userId) {
        return userDtoConverter.toUserDto(userService.getUserById(userId));
    }
}
