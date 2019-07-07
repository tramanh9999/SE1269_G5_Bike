package group5.BikeAPI.BikeHiringAPI.spring.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@Getter
@Setter
public class ErrorDetail {
    private Date timeStamp;
    private  String message;
    private String detail;


    public ErrorDetail(Date timeStamp, String message, String detail) {
        this.timeStamp = timeStamp;
        this.message = message;
        this.detail = detail;
    }


}
