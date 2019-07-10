package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Bike;
import group5.BikeAPI.BikeHiringAPI.spring.domain.BikeSlot;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BikeService {
    List<Bike> all();

    boolean insert(Bike a);

    boolean deleteById(int id);

    boolean updateById(int id, Bike bike);

    Optional<Bike> findById(int id);

    List<Bike> getAmount(int amount);

    void updateSlots(int id,List<BikeSlot> bikeSlotList);

    //map with getlastinddex in repo
    int getLastIndex();

}
