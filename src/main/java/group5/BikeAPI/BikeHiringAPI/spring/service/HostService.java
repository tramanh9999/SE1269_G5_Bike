package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Host;

import java.util.List;
import java.util.Optional;

public interface HostService {
    List<Host> all();
    void insert(Host host);
    void deleteById(int id);

    boolean updateById(int id, Host host);

    Optional<Host> findById(int id);
}
