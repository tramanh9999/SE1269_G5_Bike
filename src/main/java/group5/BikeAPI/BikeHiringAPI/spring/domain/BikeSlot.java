package group5.BikeAPI.BikeHiringAPI.spring.domain;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@Table(name = "bike_slot")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BikeSlot implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    int sid=0;
    @Column(name = "s_from")
    Date s_from;
    @Column(name = "s_to")
    Date s_to;
    @Column(name = "fee")
    long fee;
    @ManyToOne
    @JoinColumn(name = "bikeId")
    Bike bike;


}
