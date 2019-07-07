package group5.BikeAPI.BikeHiringAPI.spring.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
@Getter
@Setter
public class Order {
    int orderId;
    int cusId;
    int bikeId;
    Date date;
    String deliveryLocation;
    List<BikeSlot> slotList;


}
