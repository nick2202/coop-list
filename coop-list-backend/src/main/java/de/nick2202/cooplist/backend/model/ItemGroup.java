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
public class ItemGroup {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "item_group_id")
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "itemGroup")
    private List<ListItem> listItems;

    @ManyToMany(mappedBy = "itemGroups")
    private List<AppUser> appAppUsers;

    public ItemGroup(String name) {
        this.name = name;
    }
}
