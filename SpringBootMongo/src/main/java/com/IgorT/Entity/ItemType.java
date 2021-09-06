package com.IgorT.Entity;

import org.springframework.boot.autoconfigure.domain.EntityScan;

import javax.persistence.*;
import java.sql.Time;
@EntityScan
@Entity
@Table(name="Itemtype")
public class ItemType {
    @Id
    //@OneToOne(mappedBy="itemType", fetch=FetchType.EAGER)
    private int id;
    @Column
    private String itemName;


    @Column(name="ItemDescription")
    private String ItemDescription;

    @Column
    private Time itemExpectedTime;

    public ItemType(String itemName, Time itemExpectedTime) {
        this.itemName = itemName;
        this.itemExpectedTime = itemExpectedTime;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Time getItemExpectedTime() {
        return itemExpectedTime;
    }

    public void setItemExpectedTime(Time itemExpectedTime) {
        this.itemExpectedTime = itemExpectedTime;
    }

    public String getItemDescription() {        return ItemDescription;    }

    public void setItemDescription(String itemDescription) {        ItemDescription = itemDescription;    }

}
