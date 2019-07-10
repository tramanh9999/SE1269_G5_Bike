package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Bike;
import group5.BikeAPI.BikeHiringAPI.spring.domain.BikeSlot;

import java.util.List;
import java.util.Optional;

public interface SlotService {

     List<BikeSlot> all(int bid);

     boolean insert(int bid,BikeSlot bikeSlot);

     boolean deleteById(int bid, int bsid);
     boolean updateById(int bid, int bsid,BikeSlot bikeSlot);

     Optional<Account> findById(int id);

    Optional<Account> findByEmail(String email);

}
