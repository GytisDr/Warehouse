package lt.warehousemanagement.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lt.warehousemanagement.entities.Product;
import lt.warehousemanagement.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	ProductRepository productRepository;
	
	public Product save(Product product) {
		return productRepository.save(product);
	}
	
	public List<Product> getAll() {
		return productRepository.findAll();
	}
	
	public void delete(Product product) {
		productRepository.delete(product);
	}
	
	public Optional<Product> findById(int id) {
		return productRepository.findById(id);
	}
}
