package group5.BikeAPI.BikeHiringAPI.spring.domain;


import com.fasterxml.jackson.databind.ObjectMapper;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Bike")
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

//
//    public String getLocation() {
//        return location;
//    }
//
//    public void setLocation(String location) {
//        this.location = location;
//    }
//
//
//    public Date getUpdateDate() {
//        return updateDate;
//    }
//
//    public void setUpdateDate(Date updateDate) {
//        this.updateDate = updateDate;
//    }



    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNoPlate() {
        return noPlate;
    }

    public void setNoPlate(String noPlate) {
        this.noPlate = noPlate;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(String ownerId) {
        this.ownerId = ownerId;
    }

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    public List getSlotList() {
        return slotList;
    }

    public void setSlotList(List<BikeSlot> slotList) {
        this.slotList = slotList;
    }


}
