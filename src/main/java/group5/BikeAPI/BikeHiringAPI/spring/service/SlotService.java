package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Slot;

import java.util.List;
import java.util.Optional;

public interface SlotService {
    List<Slot> all();
    void insert(Slot s);
    void deleteById(int id);

    boolean updateById(int id, Slot slot);

    Optional<Slot> findById(int id);
}
