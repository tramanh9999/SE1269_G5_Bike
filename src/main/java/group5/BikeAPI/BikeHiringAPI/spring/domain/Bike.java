package group5.BikeAPI.BikeHiringAPI.spring.domain;


import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Bike")
@Getter
@Setter
public class Bike implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int bikeId;

    @Column(name = "name")
    String name;

    @Column(name = "brand", length = 255)
    String brand;

    @Column(name = "noPlate")
    String noPlate;

    @Column(name = "capacity")
    String capacity;

    @Column(name = "ownerId")
    String ownerId;

    @Column(name = "cityId")
    String cityId;


//    @Column(name = "location")
//    String location;
//
//
//    @Column(name = "updateDate")
//    Date updateDate;

    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "BikeSlot", joinColumns = @JoinColumn(name = "bikeId"))
    List<BikeSlot> slotList;





}
