package group5.BikeAPI.BikeHiringAPI.spring.domain;


import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Bike")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Bike implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int bikeId = 0;
    //thong tin chinh
    @Column(name = "name")
    String name;
    @Column(name = "image")
    String image;
    @ManyToOne
    Garage garage;
    //vi tri
    @Column(name = "display_location")
    String display_location;
    @Column(name = "lat")
    long latitude = 0;
    @Column(name = "long")
    long longitude = 0;


    @OneToMany(mappedBy = "bike")
    List<BikeSlot> slotList = new ArrayList<>();

    //thong tin lien quan
    @Column(name = "description")
    String description;
    @Column(name = "noPlate")
    String noPlate;
    @Column(name = "capacity")
    String capacity;
    @Column(name = "cityId")
    String cityId;


}
