package lt.warehousemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.warehousemanagement.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	User findByUsername(String username);

}
