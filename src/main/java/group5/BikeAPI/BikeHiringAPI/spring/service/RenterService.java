package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Renter;

import java.util.List;
import java.util.Optional;

public interface RenterService {
    List<Renter> all();
    void insert(Renter renter);
    void deleteById(int id);

    boolean updateById(int id, Renter renter);

    Optional<Renter> findById(int id);
}
