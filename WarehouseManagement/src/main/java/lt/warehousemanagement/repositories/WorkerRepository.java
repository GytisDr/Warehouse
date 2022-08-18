package lt.warehousemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.warehousemanagement.entities.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Integer> {

}
