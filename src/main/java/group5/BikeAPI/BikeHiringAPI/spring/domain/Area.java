package group5.BikeAPI.BikeHiringAPI.spring.domain;

import io.swagger.annotations.ApiModel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Area")
@ApiModel("Area")
@Getter
@Setter
public class Area {
    @Id
    int areaId;
    @Column(name = "name", length = 255)
    String name;

}
