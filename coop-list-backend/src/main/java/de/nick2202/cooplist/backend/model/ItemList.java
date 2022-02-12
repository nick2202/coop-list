package de.nick2202.cooplist.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ItemList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_list.item_list_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "itemList", cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<ListItem> listItems;

    @JoinTable(name = "item_list_users")
    @ManyToMany(cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    private List<User> users;

    public static ItemList addUserToList(ItemList itemList, User user) {
        itemList.getUsers().add(user);
        return itemList;
    }

    public ItemList(String name, List<User> users) {
        this.name = name;
        this.users = users;
    }
}
