package lt.warehousemanagement.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import lt.warehousemanagement.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Integer>{

}
