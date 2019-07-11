package group5.BikeAPI.BikeHiringAPI.spring.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "garage")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Garage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id = 0;
    @Column(name = "name")
    String name;

    @Column(name = "create_date")
    Date create_date;

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
    long balance = 0L;

    @OneToOne
    @JoinColumn(name = "id",foreignKey = @ForeignKey(name = "account_id"))
    Account bike;

}
