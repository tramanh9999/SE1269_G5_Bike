package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Garage;
import group5.BikeAPI.BikeHiringAPI.spring.repository.GarageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarageServiceImpl implements GarageService {

    @Autowired
    GarageRepository garageRepository;

    @Override
    public List<Garage> all() {
        return garageRepository.findAll();
    }

    @Override
    public int getLastIndex() {
        return garageRepository.getLastIndex();
    }

    @Override
    public boolean insert(Garage a) {
        garageRepository.save(a);
        return true;

    }

    @Override
    public boolean deleteById(int id) {
        garageRepository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateById(int id, Garage a) {
        a.setGid(id);
        garageRepository.save(a);
        return true;
    }

    @Override
    public Optional<Garage> findById(int id) {
         return garageRepository.findById(id);

    }
}
