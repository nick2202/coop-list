package de.nick2202.cooplist.backend.service;

import de.nick2202.cooplist.backend.model.Item;
import de.nick2202.cooplist.backend.model.ItemList;
import de.nick2202.cooplist.backend.model.ListItem;
import de.nick2202.cooplist.backend.model.User;
import de.nick2202.cooplist.backend.repository.ItemListRepository;
import de.nick2202.cooplist.backend.repository.ItemRepository;
import de.nick2202.cooplist.backend.repository.ListItemRepository;
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
public class ListItemServiceTest {

    @Mock
    ListItemRepository listItemRepository;
    @Mock
    ItemRepository itemRepository;
    @Mock
    ItemListRepository itemListRepository;

    @InjectMocks
    ListItemService listItemService;

    @Test
    public void checkListItem() {
        Item item = new Item("Butter");
        User user = new User();
        ItemList itemList = new ItemList("Shopping List", List.of(user));
        itemList.setId(1L);
        ListItem listItem = new ListItem(item, itemList);

        Mockito.when(listItemRepository.save(Mockito.any(ListItem.class)))
                .then((Answer<ListItem>) invocationOnMock -> invocationOnMock.getArgument(0));
        Mockito.when(listItemRepository.findAllByItemListAndItem(itemList, item)).thenReturn(List.of(listItem));
        Mockito.when(itemRepository.findFirstByName(item.getName())).thenReturn(Optional.of(item));
        Mockito.when(itemListRepository.findById(itemList.getId())).thenReturn(Optional.of(itemList));

        ListItem savedListItem = listItemRepository.save(listItem);
        Assertions.assertThat(savedListItem)
                .hasFieldOrPropertyWithValue("checked", false);
        listItemService.checkListItem(itemList.getId(), item.getName());
        Assertions.assertThat(savedListItem)
                .hasFieldOrPropertyWithValue("checked", true);
        Mockito.verify(listItemRepository, times(2)).save(Mockito.any(ListItem.class));
    }
}