package lt.warehousemanagement.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lt.warehousemanagement.entities.Role;
import lt.warehousemanagement.entities.User;
import lt.warehousemanagement.services.UserService;

@Controller
@RequiredArgsConstructor
public class UserController {

private final UserService userService;
	
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getUsers(){
	
		return ResponseEntity.ok().body(userService.getUsers());
	}
	

	@PostMapping("/user/save")
	public ResponseEntity<User> saveUser(@RequestBody User user){
		
		return ResponseEntity.ok().body(userService.save(user));
	}
	
	@PostMapping("/admin/saverole")
	public ResponseEntity<Role> saveRole(@RequestBody Role role){
		
		return ResponseEntity.ok().body(userService.save(role));
	}
	
	@PostMapping("/admin/addToUser")
	public ResponseEntity<?> addRoleToUser(@RequestBody RoleUserForm form){
		
		userService.addRoleToUser(form.getUsername(), form.getRolename());
		return ResponseEntity.ok().build();
	}
	
	
	
}

@Data
class RoleUserForm{
	private String username;
	private String rolename;

	
}
