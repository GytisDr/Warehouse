package lt.warehousemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.warehousemanagement.entities.Manager;

public interface ManagerRepository extends JpaRepository<Manager, Integer> {

}
