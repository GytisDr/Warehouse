package lt.warehousemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.warehousemanagement.entities.Order;
import lt.warehousemanagement.repositories.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderRepository orderRepository;
	
	public Order save(Order order) {
		return orderRepository.save(order);
	}
	
	public List<Order> getAll() {
		return orderRepository.findAll();
	}
	
	public void delete(Order order) {
		orderRepository.delete(order);
	}
	
	public Optional<Order> findById(int id) {
		return orderRepository.findById(id);
		
	}

}
