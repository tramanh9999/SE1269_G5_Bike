package group5.BikeAPI.BikeHiringAPI.spring.domain;

import javax.persistence.*;

@Entity
public class Host {
    @Id
    int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email", length = 255)
    String email;
    @Column(name = "phone", length = 255)
    String phone;
    @Column(name = "balance", length = 255)
    String balance;

}
