package group5.BikeAPI.BikeHiringAPI.spring.service;

import group5.BikeAPI.BikeHiringAPI.spring.domain.Order;
import group5.BikeAPI.BikeHiringAPI.spring.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImp implements OrderService{
    @Autowired
    OrderRepository orderRepository;
    @Override
    public List<Order> all() {
        return orderRepository.findAll();
    }

    @Override
    public void insert(Order a) {
        orderRepository.save(a);
    }

    @Override
    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }

    @Override
    public boolean updateById(int id, Order a) {
        if (orderRepository.existsById(id)) {
            a.setOrderId(id);
            orderRepository.save(a);
            return true;
        }
        return false;
    }

    @Override
    public Optional<Order> findById(int id) {
        return orderRepository.existsById(id) ? orderRepository.findById(id) : null;
    }
}
