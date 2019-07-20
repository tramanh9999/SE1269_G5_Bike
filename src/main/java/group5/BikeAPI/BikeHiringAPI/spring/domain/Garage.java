package group5.BikeAPI.BikeHiringAPI.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tbl_garage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id = 0;
    @Column(name = "_name")
    String name;
    @Column(name = "create_date")
    Date create_date;
    @Column(name = "_phone")
    String phone;
    @Column(name = "description")
    String description;
    @Column(name = "lat")
    long latitude = 0;
    @Column(name = "_long")
    long longitude = 0;
    @Column(name = "display_location")
    String display_location;
    @Column(name = "_balance")
    long balance = 0L;
    @OneToMany
    List<Image> imageList;

    @OneToMany
    List<Bike> bikeList;
}
