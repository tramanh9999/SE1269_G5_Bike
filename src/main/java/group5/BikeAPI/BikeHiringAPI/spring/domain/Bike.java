package group5.BikeAPI.BikeHiringAPI.spring.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tbl_bike")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   public  int id = 0;
    //thong tin chinh
    @Column(name = "_name")
    String name;
    @OneToMany
    List<Image> imageList;
    @ManyToOne(fetch = FetchType.LAZY)
    Garage garage;
    @OneToMany(mappedBy = "bike")
    List<Slot> slot_list = new ArrayList<>();
    //thong tin lien quan
    @Column(name = "description")
    String description;
    @Column(name = "no_plate")
    String no_plate;
    @Column(name = "capacity")
    String capacity;
    //vi tri
    @Column(name = "display_location")
    String display_location;
    @Column(name = "_lat")
    long latitude = 0;
    @Column(name = "_long")
    long longitude = 0;
    @Column(name = "_isAvaiable")
    boolean _isAvaiable;

}
