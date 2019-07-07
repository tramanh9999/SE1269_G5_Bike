package group5.BikeAPI.BikeHiringAPI.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Renter")
@Getter
@Setter
public class Renter {
    @Id
    int renterId;
    @Column(name = "phone", length = 255)
    String phone;
    @Column(name = "renterName", length = 255)
    String renterName;

}
