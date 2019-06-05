package group5.BikeAPI.BikeHiringAPI.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name="Slot")
public class Slot {
    @Column(name = "from", length = 255)
    Date from;
    @Column(name = "to", length = 255)
    Date to;

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
