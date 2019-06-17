package group5.BikeAPI.BikeHiringAPI.spring.repository;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Renter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RenterRepository extends JpaRepository<Renter,Integer> {
}
