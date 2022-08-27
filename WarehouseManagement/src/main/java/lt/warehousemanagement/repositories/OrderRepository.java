package lt.warehousemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.warehousemanagement.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Integer>{

}
