package group5.BikeAPI.BikeHiringAPI.spring.repository;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order,Integer> {
}
