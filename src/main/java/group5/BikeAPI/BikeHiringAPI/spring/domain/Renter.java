package group5.BikeAPI.BikeHiringAPI.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Renter")
public class Renter {
    @Id
    int renterId;
    @Column(name = "phone", length = 255)
    String phone;
    @Column(name = "renterName", length = 255)
    String renterName;

    public int getRenterId() {
        return renterId;
    }

    public void setRenterId(int renterId) {
        this.renterId = renterId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getRenterName() {
        return renterName;
    }

    public void setRenterName(String renterName) {
        this.renterName = renterName;
    }
}
