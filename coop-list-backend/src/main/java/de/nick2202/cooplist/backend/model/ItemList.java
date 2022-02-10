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
    @Column(name = "item_list_id")
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "itemList")
    private List<ListItem> listItems;

    @ManyToMany(mappedBy = "itemLists")
    private List<AppUser> appAppUsers;

    public ItemList(String name) {
        this.name = name;
    }
}
