package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Account;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Garage;
import group5.BikeAPI.BikeHiringAPI.spring.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<Order> all();

    boolean insert(Order a);

    boolean insertGarage(Order order);

    boolean deleteById(int id);

    boolean updateById(int id, Order a);

    Optional<Order> findById(int id);

    Optional<Order> findByEmail(String email);

    int getLastIndex();


}
