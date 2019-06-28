package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Host;
import group5.BikeAPI.BikeHiringAPI.spring.repository.HostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImp implements HostService{
    @Autowired
    HostRepository hostRepository;
    @Override
    public List<Host> all() {
        return hostRepository.findAll();
    }

    @Override
    public void insert(Host a) {
        hostRepository.save(a);
    }

    @Override
    public void deleteById(int id) {
        hostRepository.deleteById(id);
    }

    @Override
    public boolean updateById(int id, Host a) {
        if (hostRepository.existsById(id)) {
            a.setHostId(id);
            hostRepository.save(a);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Host> findById(int id) {
        return hostRepository.existsById(id) ? hostRepository.findById(id) : null;
    }
}
