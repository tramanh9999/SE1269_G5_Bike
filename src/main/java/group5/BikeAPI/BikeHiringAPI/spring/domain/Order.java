package group5.BikeAPI.BikeHiringAPI.spring.domain;

import lombok.*;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {


    int orderId=0;
    int accountId=0;
    int bikeId=0;
    Date orderDate;
    String deliveryLocation;
    String slotlist;
    Long total;
}
