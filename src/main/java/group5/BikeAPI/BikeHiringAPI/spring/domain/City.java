package group5.BikeAPI.BikeHiringAPI.spring.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="City")
public class City {
    @Id
    int cityId;
    @Column(name = "name", length = 255)
    String name;

    public int getCityIdityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
