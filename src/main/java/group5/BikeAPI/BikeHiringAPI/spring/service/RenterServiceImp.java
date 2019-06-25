package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Renter;
import group5.BikeAPI.BikeHiringAPI.spring.repository.RenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RenterServiceImp implements RenterService{
    @Autowired
    RenterRepository renterRepository;
    @Override
    public List<Renter> all() {
        return renterRepository.findAll();
    }

    @Override
    public void insert(Renter a) {
        renterRepository.save(a);
    }

    @Override
    public void deleteById(int id) {
        renterRepository.deleteById(id);
    }

    @Override
    public boolean updateById(int id, Renter a) {
        if (renterRepository.existsById(id)) {
            a.setRenterId(id);
            renterRepository.save(a);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Renter> findById(int id) {
        return renterRepository.existsById(id) ? renterRepository.findById(id) : null;
    }
}
