package de.nick2202.cooplist.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Group {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "group_id")
    private Long id;

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "group")
    private List<ListItem> listItems;

    @ManyToMany(mappedBy = "groups")
    private List<User> users;

    public Group(String name) {
        this.name = name;
    }
}
