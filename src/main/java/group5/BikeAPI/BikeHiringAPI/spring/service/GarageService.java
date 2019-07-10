package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Garage;

import java.util.List;
import java.util.Optional;

public interface GarageService {

    List<Garage> all();

    boolean insert(Garage a);

    boolean deleteById(int id);

    boolean updateById(int id, Garage a);

    Optional<Garage> findById(int id);

    int getLastIndex();
}