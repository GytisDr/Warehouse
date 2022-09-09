package lt.warehousemanagement.controllers;

import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;
import lt.warehousemanagement.entities.Role;
import lt.warehousemanagement.entities.User;
import lt.warehousemanagement.services.UserServiceImp;

@Controller
@RequestMapping("/admin")
@RequiredArgsConstructor
public class AdminController {
	
	private final UserServiceImp userServiceImp;
	
	@GetMapping("/all")
	public String getAllUsers(Model model) {
		model.addAttribute("users", userServiceImp.getUsers());
		return "/users/user-list";
	}
	
	@GetMapping("/edit/{id}")
	public String editUser(@PathVariable("id") Long id, Model model) {
	    User user = userServiceImp.get(id);
	    List<Role> listRoles = userServiceImp.listRoles();
	    model.addAttribute("user", user);
	    model.addAttribute("listRoles", listRoles);
	    return "users/user-form";
	}
	
	@PostMapping("/save")
	public String saveUser(User user ,BindingResult result, Model model) {
		User existingUser = userServiceImp.findByUsername(user.getUsername());

        if(existingUser != null && existingUser.getUsername() != null && !existingUser.getUsername().isEmpty()){
            result.rejectValue("username", null,
                    "There is already an account registered with the same username");
        }
        if(result.hasErrors()){
            return "/admin/create-user";
        }
		Role roleUser = userServiceImp.findByName("USER");
        user.addRole(roleUser);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
		userServiceImp.save(user);
	     
	    return "redirect:/admin/all";
	}
	
	@PostMapping("/update/{id}")
	public String updateUser(@PathVariable("id") Long id, User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			user.setId(id);
			return "users/user-form";
		}
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
		userServiceImp.save(user);
		return "redirect:/admin/all";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") Long id, Model model) {
		User user = userServiceImp.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid supplier Id:" + id));
		userServiceImp.delete(user);
		return "redirect:/admin/all";
	}
	
	@GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
         
        return "admin/create-user";
    }
}
