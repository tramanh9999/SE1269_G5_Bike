package group5.BikeAPI.BikeHiringAPI.spring.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "tbl_slotbike")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Slot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id=0;
    @Column(name = "slot_start")
    String slot_start;
    @Column(name = "slot_end")
    String slot_end;
    @Column(name = "fee")
    long fee;

    @ManyToOne
    @JoinColumn(name = "bike_id",foreignKey = @ForeignKey(name = "bike_id"))
    Bike bike;



}
