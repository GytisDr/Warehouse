package lt.warehousemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import lt.warehousemanagement.entities.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Query("SELECT u FROM User u WHERE u.userName = ?1")
    public User findByUserName(String userName);

}
