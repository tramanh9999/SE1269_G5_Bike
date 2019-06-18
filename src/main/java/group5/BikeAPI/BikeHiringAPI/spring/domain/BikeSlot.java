package group5.BikeAPI.BikeHiringAPI.spring.domain;

import org.jetbrains.annotations.Contract;

import javax.persistence.*;

import java.io.Serializable;
import java.util.Date;

@Table(name="bike_slot")

@Embeddable
public class BikeSlot implements Serializable {


    public Date getSlot_from() {
        return slot_from;
    }

    public void setSlot_from(Date slot_from) {
        this.slot_from = slot_from;
    }


    @Column(name = "slot_from")
    Date slot_from;
    @Column(name = "slot_to")
    Date slot_to;

    @Contract(pure = true)
    public BikeSlot() {
    }


    public BikeSlot(Date from, Date to) {
        this.slot_from = from;
        this.slot_to = to;
    }

    public Date getSlot_to() {
        return slot_to;
    }

    public void setSlot_to(Date slot_to) {
        this.slot_to = slot_to;
    }
}
