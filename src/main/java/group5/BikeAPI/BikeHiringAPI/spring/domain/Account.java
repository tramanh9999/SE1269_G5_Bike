package group5.BikeAPI.BikeHiringAPI.spring.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "tbl_account")
@ApiModel(description = "All information about your account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id")
    int id = 0;
    @Column(name = "_email")
    @ApiModelProperty(notes = "email address")
    String email;
    @Column(name = "_phone")
    @ApiModelProperty(notes = "phone string")
    String phone;
    @Column(name = "_balance")
    @ApiModelProperty(notes = "balance")
    long balance = 0L;
    @Column(name = "_avatar")
    String avatar;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "_garage")
    Garage garage;
}
