package group5.BikeAPI.BikeHiringAPI.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_order")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id", foreignKey = @ForeignKey(name = "account_id"), referencedColumnName = "account_id")
    Account account;
    @OneToOne
    @JoinColumn(name = "bike_id", foreignKey = @ForeignKey(name = "bike_id"))
    Bike bike;


    @Column(name = "order_date")
    Date order_date;
    @Column(name = "delivery_location")
    String delivery_location;
    @Column(name = "lat")
    Long latitude;
    @Column(name = "_long")
    Long longitude;
    // store like:  7:30AM - 9:30AM/300000|
    @Column(name = "slot_list")
    String slot_list;
    @Column(name = "total_fee")
    Long total_fee;
}
