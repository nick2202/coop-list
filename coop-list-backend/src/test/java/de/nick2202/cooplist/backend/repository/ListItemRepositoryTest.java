package de.nick2202.cooplist.backend.repository;

import de.nick2202.cooplist.backend.model.Item;
import de.nick2202.cooplist.backend.model.ItemList;
import de.nick2202.cooplist.backend.model.ListItem;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ListItemRepositoryTest {

    @Configuration
    @EnableAutoConfiguration
    @EnableJpaRepositories(basePackageClasses = ListItemRepository.class)
    @EntityScan(basePackageClasses = ListItem.class)
    static class TestConfiguration {
    }

    @Autowired
    ListItemRepository listItemRepository;
    @Autowired
    ItemRepository itemRepository;
    @Autowired
    ItemListRepository itemListRepository;

    @Before
    public void setup() {
        Item item = new Item("Butter");
        ItemList itemList = new ItemList("Shopping List");
        ListItem listItem1 = ListItem.builder()
                .id(1L)
                .item(item)
                .itemList(itemList)
                .build();

        ListItem listItem2 = ListItem.builder()
                .id(1L)
                .item(item)
                .itemList(itemList)
                .build();

        itemRepository.save(item);
        itemListRepository.save(itemList);
        listItemRepository.save(listItem1);
        listItemRepository.save(listItem2);
    }


    @Test
    public void findFirstByItem() {
        Optional<ListItem> listItem = listItemRepository.findFirstByItem_Name("Butter");

        assertThat(listItem)
                .isNotEmpty()
                .hasValueSatisfying(li -> assertThat(li)
                        .hasFieldOrPropertyWithValue("id", 3L)
                        .hasFieldOrProperty("item")
                        .hasFieldOrProperty("itemList"));
    }

}