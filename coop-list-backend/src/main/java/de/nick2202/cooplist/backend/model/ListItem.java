package de.nick2202.cooplist.backend.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "list_item_id")
    private Long id;

    @NotNull
    @ManyToOne
    private Item item;

    @NotNull
    @ManyToOne
    private Group group;

    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp timeAdded;

    @UpdateTimestamp
    private Timestamp timeChecked = null;

    private boolean checked = false;

    public ListItem(Item item, Group group) {
        this.item = item;
        this.group = group;
    }
}