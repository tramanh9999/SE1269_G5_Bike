package group5.BikeAPI.BikeHiringAPI.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import java.util.List;

@Entity
@Table(name="Bike")
public class Bike {
    @Id
    int bikeId;
    @Column(name = "name", length = 255)
    String name;
    @Column(name = "brand", length = 255)
    String brand;
    @Column(name = "noPlate", length = 255)
    String noPlate;
    @Column(name = "capacity", length = 255)
    String capacity;
    @Column(name = "ownerId", length = 255)
    String ownerId;
    @Column(name = "cityId", length = 255)
    String cityId;
    @Column(name = "slotList", length = 255)
    List slotList;

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

    public void setSlotList(List slotList) {
        this.slotList = slotList;
    }
}
