package group5.BikeAPI.BikeHiringAPI.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Garage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int gid=0;
    @Column(name = "name")
    String name;

    @Column(name = "createDate")
    Date createDate;

    @Column(name = "phone")
    String phone;
    @Column(name = "description")
    String description;

    @Column(name = "lat")
    long latitude = 0;
    @Column(name = "long")
    long longitude = 0;
    @Column(name = "display_location")
    String display_location;
    @Column(name = "balance")
    long balance=0L;

}
