package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.model.User;
import de.nick2202.cooplist.backend.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserService userService;

    @Test
    public void registerUser() {
        User user = new User("Hans", "Hansen", "TheHans", "hans@hansen.com", "geheim");

        Mockito.when(userRepository.save(Mockito.any(User.class)))
                .then((Answer<User>) invocationOnMock -> invocationOnMock.getArgument(0));
        User savedUser = userService.registerUser(user);
        Mockito.verify(userRepository).save(savedUser);
        Assertions.assertThat(savedUser)
                .hasFieldOrPropertyWithValue("firstName", user.getFirstName())
                .hasFieldOrPropertyWithValue("lastName", user.getLastName())
                .hasFieldOrPropertyWithValue("userName", user.getUserName())
                .hasFieldOrPropertyWithValue("email", user.getEmail())
                .hasFieldOrPropertyWithValue("password", user.getPassword());
    }

    @Test
    public void deleteUser() {
        User user = new User();
        user.setId(1L);

//        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        userService.deleteUser(user.getId());
        Mockito.verify(userRepository).deleteById(user.getId());
    }

}