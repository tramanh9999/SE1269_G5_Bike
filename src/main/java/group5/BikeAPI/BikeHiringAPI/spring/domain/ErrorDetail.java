package group5.BikeAPI.BikeHiringAPI.spring.domain;

import lombok.*;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorDetail {
    private  String message;
    private String detail;
    private Date timeStamp;



}
