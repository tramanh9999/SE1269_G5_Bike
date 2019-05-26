package group5.BikeAPI.BikeHiringAPI.spring.domain;

import javax.annotation.Generated;
import javax.persistence.*;

@Entity
@Table(name="Account")
public class Account {
    @Id
    int id;
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "email", length = 255)
    String email;
    @Column(name = "phone", length = 255)
    String phone;
    @Column(name = "balance", length = 255)
    String balance;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }






}
