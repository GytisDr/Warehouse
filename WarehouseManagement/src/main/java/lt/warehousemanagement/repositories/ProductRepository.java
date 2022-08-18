package lt.warehousemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.warehousemanagement.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>{

}
