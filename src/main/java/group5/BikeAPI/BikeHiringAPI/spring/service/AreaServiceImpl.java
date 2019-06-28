package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Area;
import group5.BikeAPI.BikeHiringAPI.spring.repository.AreaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AreaServiceImpl implements AreaService{
    @Autowired
    AreaRepository areaRepository;
    @Override
    public List<Area> all() {
        return areaRepository.findAll();
    }

    @Override
    public void insert(Area a) {
        areaRepository.save(a);
    }

    @Override
    public void deleteById(int id) {
        areaRepository.deleteById(id);
    }

    @Override
    public boolean updateById(int id, Area a) {
        if (areaRepository.existsById(id)) {
            a.setAreaId(id);
            areaRepository.save(a);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Area> findById(int id) {
        return areaRepository.existsById(id) ? areaRepository.findById(id) : null;
    }
}
