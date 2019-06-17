package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    List<Order> all();
    void insert(Order order);
    void deleteById(int id);

    boolean updateById(int id, Order order);

    Optional<Order> findById(int id);
}
