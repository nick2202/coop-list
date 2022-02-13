package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.model.ItemList;
import de.nick2202.cooplist.backend.model.ListItem;
import de.nick2202.cooplist.backend.model.User;
import de.nick2202.cooplist.backend.repository.ItemListRepository;
import de.nick2202.cooplist.backend.repository.UserRepository;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.times;

@RunWith(SpringJUnit4ClassRunner.class)
public class ItemListServiceTest {

    @Mock
    private ItemListRepository itemListRepository;
    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private ItemListService itemListService;

    @Test
    public void addItemList() {
        User user = new User();
        ListItem listItem = new ListItem();
        ItemList itemList = new ItemList("List", List.of(user));
        itemList.setListItems(List.of(listItem));

        Mockito.when(itemListRepository.save(Mockito.any(ItemList.class)))
                .then((Answer<ItemList>) invocationOnMock -> invocationOnMock.getArgument(0));
        ItemList savedItemList = itemListRepository.save(itemList);
        Mockito.verify(itemListRepository).save(savedItemList);
        Assertions.assertThat(savedItemList)
                .hasFieldOrPropertyWithValue("name", itemList.getName())
                .hasFieldOrPropertyWithValue("users", itemList.getUsers())
                .hasFieldOrPropertyWithValue("listItems", itemList.getListItems());
    }

    @Test
    public void addUser() {
        User user = new User();
        user.setId(1L);
        ItemList itemList = new ItemList("List", List.of(user));
        itemList.setId(2L);
        User userToAdd = new User();
        userToAdd.setId(3L);

        Mockito.when(itemListRepository.save(Mockito.any(ItemList.class)))
                .then((Answer<ItemList>) invocationOnMock -> invocationOnMock.getArgument(0));
        Mockito.when(itemListRepository.findById(itemList.getId())).thenReturn(Optional.of(itemList));
        Mockito.when(userRepository.findById(user.getId())).thenReturn(Optional.of(user));
        Mockito.when(userRepository.findById(userToAdd.getId())).thenReturn(Optional.of(userToAdd));

        ItemList savedItemList = itemListRepository.save(itemList);
        itemListService.addUser(user.getId(),
                savedItemList.getId(),
                userToAdd.getId());
        ItemList savedItemListWithNewUser = itemListRepository.save(itemList);
        System.out.println(itemList.getUsers());
        itemList.setUsers(List.of(user, userToAdd));
        Mockito.verify(itemListRepository, times(3)).save(Mockito.any(ItemList.class));
        Assertions.assertThat(savedItemListWithNewUser)
                .hasFieldOrPropertyWithValue("name", itemList.getName())
                .hasFieldOrPropertyWithValue("users", itemList.getUsers());

    }

//    @Test
//    public void deleteItemList() {
//    }
}