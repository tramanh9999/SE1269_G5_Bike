package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Bike;
import group5.BikeAPI.BikeHiringAPI.spring.repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BikeServiceImpl implements BikeService {


    @Autowired
    BikeRepository bikeRepository;


    @Override
    public List<Bike> all() {
        return bikeRepository.findAll();

    }

    @Override
    public void insert(Bike a) {
        bikeRepository.save(a);
    }

    @Override
    public void deleteById(int id) {
        bikeRepository.deleteById(id);
    }

    @Override
    public boolean updateById(int id, Bike a) {
        if (bikeRepository.existsById(id)) {
            a.setBikeId(id);
            bikeRepository.save(a);
            return true;
        }
        return false;


    }

    @Override
    public Optional<Bike> findById(int id) {
        return bikeRepository.existsById(id) ? bikeRepository.findById(id) : null;
    }
}
