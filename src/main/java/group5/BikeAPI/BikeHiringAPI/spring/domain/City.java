package group5.BikeAPI.BikeHiringAPI.spring.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="City")
@Getter
@Setter
public class City {
    @Id
    int cityId;
    @Column(name = "name", length = 255)
    String name;

}
