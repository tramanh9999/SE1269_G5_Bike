package group5.BikeAPI.BikeHiringAPI.spring.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "account")
@ApiModel(description = "All information about your account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id")
    int id = 0;
    @Column(name = "email")
    @ApiModelProperty(notes = "email address")
    String email;
    @Column(name = "phone")
    @ApiModelProperty(notes = "phone string")
    String phone;
    @Column(name = "balance")
    @ApiModelProperty(notes = "balance")
    long balance = 0L;
    @Column(name = "avatar")
    String avatar;

    @OneToOne(mappedBy = "bike")
    @ApiModelProperty(notes = "garage")
    Garage garage;


}
