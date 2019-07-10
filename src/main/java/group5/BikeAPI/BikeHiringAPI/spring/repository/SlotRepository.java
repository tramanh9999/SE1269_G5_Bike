package group5.BikeAPI.BikeHiringAPI.spring.repository;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import group5.BikeAPI.BikeHiringAPI.spring.domain.BikeSlot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotRepository extends JpaRepository<BikeSlot, Integer> {


}
