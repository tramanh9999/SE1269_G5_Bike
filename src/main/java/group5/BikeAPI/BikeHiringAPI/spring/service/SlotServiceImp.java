package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Slot;
import group5.BikeAPI.BikeHiringAPI.spring.repository.SlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SlotServiceImp implements SlotService {
    @Autowired
    SlotRepository slotRepository;

    @Override
    public List<Slot> all() {
        return slotRepository.findAll();
    }

    @Override
    public void insert(Slot s) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public boolean updateById(int id, Slot slot) {
        return false;
    }

    @Override
    public Optional<Slot> findById(int id) {
        return Optional.empty();
    }
}
