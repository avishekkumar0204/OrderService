package dev.avishek.orderservice.repositories;

import dev.avishek.orderservice.models.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Order save(Order order);
    List<Order> findAllByUserId(Long userId);
    Optional<Order> findById(Long id);
}
