package group5.BikeAPI.BikeHiringAPI.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="Order")
public class OrderDTO {
    @Id
    int orderId;
    @Column(name = "cusId", length = 255)
    int cusId;
    @Column(name = "bikeId", length = 255)
    int bikeId;
    @Column(name = "date", length = 255)
    Date date;
    @Column(name = "deliveryLocation", length = 255)
    String deliveryLocation;
    @Column(name = "slotList", length = 255)
    String slotList;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCusId() {
        return cusId;
    }

    public void setCusId(int cusId) {
        this.cusId = cusId;
    }

    public int getBikeId() {
        return bikeId;
    }

    public void setBikeId(int bikeId) {
        this.bikeId = bikeId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDeliveryLocation() {
        return deliveryLocation;
    }

    public void setDeliveryLocation(String deliveryLocation) {
        this.deliveryLocation = deliveryLocation;
    }

    public String getSlotList() {
        return slotList;
    }

    public void setSlotList(String slotList) {
        this.slotList = slotList;
    }
}
