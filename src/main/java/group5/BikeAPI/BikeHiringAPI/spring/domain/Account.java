package group5.BikeAPI.BikeHiringAPI.spring.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.Getter;
import lombok.Setter;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name = "Account")
@ApiModel(description = "All information about your account")

@Getter
@Setter
public class Account {
    @Id
    @ApiModelProperty(notes = "Account Id")
    int id;

    @Column(name = "email", length = 255)
    @ApiModelProperty(notes = "Account email address")
    String email;

    @Column(name = "phone", length = 255)
    @ApiModelProperty(notes = "Account phone string")
    String phone;
    @Column(name = "balance", length = 255)
    @ApiModelProperty(notes = "Account balance string")
    String balance;



}
