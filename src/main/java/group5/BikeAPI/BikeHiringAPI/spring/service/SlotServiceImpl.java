package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Slot;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlotServiceImpl implements SlotService {


    @Override
    public List<Slot> all(int bid) {
        return null;
    }

    @Override
    public boolean insert(int bid, Slot bikeSlot) {
        return false;
    }

    @Override
    public boolean deleteById(int bid, int bsid) {
        return false;
    }

    @Override
    public boolean updateById(int bid, int bsid, Slot bikeSlot) {
        return false;
    }

    @Override
    public Optional<Slot> findById(int id) {
        return Optional.empty();
    }


}
