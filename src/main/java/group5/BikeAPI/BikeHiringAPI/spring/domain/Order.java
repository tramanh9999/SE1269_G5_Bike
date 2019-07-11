package group5.BikeAPI.BikeHiringAPI.spring.domain;

import lombok.*;

import java.util.Date;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {


    int id=0;
    int account_id=0;
    int bike_id=0;
    Date order_date;
    String delivery_location;
    String slot_list;
    Long total_fee;
}
