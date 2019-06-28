package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Bike;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Optional;

public interface BikeService {
    List<Bike> all();

    void insert(Bike a);

    void deleteById(int id);

    boolean updateById(int id, Bike bike);

    Optional<Bike> findById(int id);


    List<Bike> getAmount(int amount);
}
