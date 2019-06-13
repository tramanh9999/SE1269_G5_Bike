package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.City;

import java.util.List;
import java.util.Optional;

public interface CityService {
    List<City> all();
    void insert(City c);
    void deleteById(int id);

    boolean updateById(int id, City city);

    Optional<City> findById(int id);
}
