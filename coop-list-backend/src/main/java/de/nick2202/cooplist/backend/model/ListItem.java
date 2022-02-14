package de.nick2202.cooplist.backend.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
@AllArgsConstructor
@Builder(access = AccessLevel.PUBLIC)
public class ListItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "list_item_id")
    private Long id;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
    private Item item;

    @NotNull
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JsonBackReference
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