package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.BikeSlot;
import group5.BikeAPI.BikeHiringAPI.spring.repository.BikeSlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeSlotServiceImp implements BikeSlotService {
    @Autowired
    BikeSlotRepository bikeSlotRepository;

    @Override
    public List<BikeSlot> all() {
        return bikeSlotRepository.findAll();
    }

    @Override
    public void insert(BikeSlot bs) {
        bikeSlotRepository.save(bs);
    }

    @Override
    public void deleteById(int id) {
        bikeSlotRepository.deleteById(id);
    }

    @Override
    public boolean updateById(int id, BikeSlot bs) {
        return false;
    }

    @Override
    public Optional<BikeSlot> findById(int id) {
        return Optional.empty();
    }
}
