package group5.BikeAPI.BikeHiringAPI.spring.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Account")
@ApiModel(description = "All information about your account")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Id")
    int id=0;
    @Column(name = "email", length = 255)
    @ApiModelProperty(notes = "email address")
    String email;
    @Column(name = "phone", length = 255)
    @ApiModelProperty(notes = "phone string")
    String phone;
    @Column(name = "balance")
    @ApiModelProperty(notes = "balance")
    long balance=0L;
    @Column(name = "avatar")
    String avatar;







}
