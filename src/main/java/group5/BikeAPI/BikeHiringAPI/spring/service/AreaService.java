package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Area;

import java.util.List;
import java.util.Optional;

public interface AreaService {
    List<Area> all();
    void insert(Area area);
    void deleteById(int id);

    boolean updateById(int id, Area area);

    Optional<Area> findById(int id);
}
