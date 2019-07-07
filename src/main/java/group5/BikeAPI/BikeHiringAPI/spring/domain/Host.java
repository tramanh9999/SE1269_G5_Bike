package group5.BikeAPI.BikeHiringAPI.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Host")
@Getter
@Setter
public class Host {
    @Id
    int hostId;
    @Column(name = "phone", length = 255)
    String phone;
    @Column(name = "hostName", length = 255)
    String hostName;


}
