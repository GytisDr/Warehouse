package lt.warehousemanagement.controllers;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;
import lt.warehousemanagement.entities.Role;
import lt.warehousemanagement.entities.User;
import lt.warehousemanagement.services.UserServiceImp;

@Controller
@RequiredArgsConstructor
public class MainController {
	
	private final UserServiceImp userServiceImp;
	
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
	@GetMapping("/index")
	public String index() {
		return "index";
	}
	
	@GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
         
        return "/users/signup-form";
    }
	
	@PostMapping("/process_register")
    public String processRegister(User user, BindingResult result) {
		User existingUser = userServiceImp.findByUsername(user.getUsername());

        if(existingUser != null && existingUser.getUsername() != null && !existingUser.getUsername().isEmpty()){
            result.rejectValue("username", null,
                    "There is already an account registered with the same username");
        }
        if(result.hasErrors()){
            return "/users/signup-form";
        }
		Role roleUser = userServiceImp.findByName("USER");
        user.addRole(roleUser);
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userServiceImp.save(user);
         
        return "users/register-success";
    }
	
	@GetMapping("/loginUm")
	public String login() {
		return "login";
	}

	
}
