package de.nick2202.cooplist.backend.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
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
    private ItemList itemList;

    @Column(updatable = false)
    @CreationTimestamp
    private Timestamp timeAdded;

    @UpdateTimestamp
    private Timestamp timeChecked = null;

    private boolean checked = false;

    public static ListItem check(ListItem listItem) {
        listItem.setChecked(true);
        return listItem;
    }

    public ListItem(Item item, ItemList itemList) {
        this.item = item;
        this.itemList = itemList;
    }

}