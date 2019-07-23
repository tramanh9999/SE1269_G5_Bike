package group5.BikeAPI.BikeHiringAPI.spring.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tbl_account")
@ApiModel(description = "All information about your account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "account_id")
    @Column(name = "account_id")
    int id = 0;
    @Column(name = "_email")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "email address")

    String email;
    @Column(name = "_name")
    @ApiModelProperty(notes = "Display name")
    String username;
    @Column(name = "_phone")
    @ApiModelProperty(notes = "phone string")
    String phone;
    @Column(name = "_balance")
    @ApiModelProperty(notes = "balance")
    long balance = 0L;
    @Column(name = "_avatar")
    String avatar;
    @OneToOne
    @JoinColumn(name = "_garage")
    Garage garage;
}
