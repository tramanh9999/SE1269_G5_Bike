package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Slot;

import java.util.List;
import java.util.Optional;

public interface SlotService {

     List<Slot> all(int bid);

     boolean insert(int bid,Slot bikeSlot);

     boolean deleteById(int bid, int bsid);
     boolean updateById(int bid, int bsid, Slot bikeSlot);

     Optional<Slot> findById(int id);


}
