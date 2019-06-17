package group5.BikeAPI.BikeHiringAPI.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Slot")
public class Slot {

    @Id
    int id;
    @Column(name = "from", length = 255)
    Date from;
    @Column(name = "to", length = 255)
    Date to;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFrom() {
        return from;
    }

    public void setFrom(Date from) {
        this.from = from;
    }

    public Date getTo() {
        return to;
    }

    public void setTo(Date to) {
        this.to = to;
    }
}
