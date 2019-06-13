package group5.BikeAPI.BikeHiringAPI.spring.repository;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends JpaRepository<Bike, Integer> {

}
