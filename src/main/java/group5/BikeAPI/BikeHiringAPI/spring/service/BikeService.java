package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Bike;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Slot;

import java.util.List;
import java.util.Optional;

public interface BikeService {
    List<Bike> all();

    boolean insert(Bike a);

    boolean deleteById(int id);

    boolean updateById(int id, Bike bike);

    Optional<Bike> findById(int id);

    List<Bike> getAmount(int amount);

    void updateSlotList(int id, List<Slot> slotList);

    //map with getlastinddex in repo
    int getLastIndex();

}
