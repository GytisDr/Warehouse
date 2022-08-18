package lt.warehousemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.warehousemanagement.entities.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
