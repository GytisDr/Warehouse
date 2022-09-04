package lt.warehousemanagement.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lt.warehousemanagement.entities.Role;
import lt.warehousemanagement.entities.User;
import lt.warehousemanagement.repositories.RoleRepository;
import lt.warehousemanagement.repositories.UserRepository;

@Service
@Transactional 
@RequiredArgsConstructor
public class UserServiceImp implements UserService, UserDetailsService {

	private final UserRepository userRepo;
	private final RoleRepository roleRepo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = getUser(username);
		if(user == null) {
			throw new UsernameNotFoundException(username);
		}
		
		//We will return User from spring security package
		//so we need to get Authorities list from the user first
		Collection<SimpleGrantedAuthority> authorities = new ArrayList<>();
		//getting roles from our user and adding them to authorities list
		user.getRoles().forEach( role -> {
			authorities.add(new SimpleGrantedAuthority( role.getName()));
		});
		
		//Next we have to create special User for Spring security
		var resultUser = new org.springframework.security.core.userdetails  //package name here
				.User(
					user.getName(),
					user.getPassword(),
					authorities						
				);
		//We have to return special type of User here
		return resultUser;
	}
	@Override
	public User save(User user) {
		return userRepo.save(user);
	}
	@Override
	public Role save(Role role) {
		return roleRepo.save(role);
	}
	@Override
	public void addRoleToUser(String username, String roleName) {
		User user = userRepo.findByUsername(username);
		Role role = roleRepo.findByName(roleName);
		user.getRoles().add(role);	
		userRepo.save(user);
		
	}
	@Override
	public User getUser(String username) {
		return userRepo.findByUsername(username);
	}
	@Override
	public List<User> getUsers() {
		return userRepo.findAll();
	}
	@Override
	public void updatePassword(String username, String newPassword) {
		User user = getUser(username);
		user.setPassword(newPassword);
		userRepo.save(user);
		
	}
	
	
}
