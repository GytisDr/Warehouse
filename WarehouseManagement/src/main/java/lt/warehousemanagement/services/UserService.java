package lt.warehousemanagement.services;

import java.util.List;

import lt.warehousemanagement.entities.Role;
import lt.warehousemanagement.entities.User;

public interface UserService {

	User save(User user);
	Role save(Role role);
	void addRoleToUser(String username, String roleName);
	User getUser(String username);
	
	List<User> getUsers();
	void updatePassword(String username, String newPassword);
}
