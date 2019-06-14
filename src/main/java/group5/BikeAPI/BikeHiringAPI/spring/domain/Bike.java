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


    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "BikeSlot", joinColumns = @JoinColumn(name = "bikeId"))
    List<BikeSlot> slotList;

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

    public static void main(String[] args) {
        ObjectMapper jsObject = new ObjectMapper();

        Bike bk = new Bike();
        bk.bikeId = 1;
        bk.slotList = new ArrayList<>();
        bk.slotList.add(new BikeSlot(new Date(2018, 11, 20), new Date(2019, 11, 12)));
        bk.slotList.add(new BikeSlot(new Date(2019, 7, 20), new Date(2019, 10, 12)));
        try {
            System.out.println(jsObject.writeValueAsString(bk));
        } catch (Exception e) {

        }
    }
}
