package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import group5.BikeAPI.BikeHiringAPI.spring.domain.BikeSlot;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Garage;
import group5.BikeAPI.BikeHiringAPI.spring.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlotServiceImpl implements SlotService {


    @Override
    public List<BikeSlot> all(int bid) {
        return null;
    }

    @Override
    public boolean insert(int bid, BikeSlot bikeSlot) {
        return false;
    }

    @Override
    public boolean deleteById(int bid, int bsid) {
        return false;
    }

    @Override
    public boolean updateById(int bid, int bsid, BikeSlot bikeSlot) {
        return false;
    }

    @Override
    public Optional<Account> findById(int id) {
        return Optional.empty();
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        return Optional.empty();
    }
}
