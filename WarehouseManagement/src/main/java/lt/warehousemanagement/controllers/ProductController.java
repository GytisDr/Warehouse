package lt.warehousemanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lt.warehousemanagement.entities.Product;
import lt.warehousemanagement.services.ProductService;

@Controller
@RequestMapping("/products")
public class ProductController {

	@Autowired
	ProductService productService;
	
	@PostMapping("/save")
	public String saveProduct(Product product) {
		productService.save(product);
		return "redirect:/products/create";
	}
	
	@GetMapping("/create")
	public String showCreateForm(Product product) {
		return "/products/add-product";
	}
	
	@GetMapping("/all")
	public String getAllProducts(Model model) {
		model.addAttribute("products", productService.getAll());
		return "/products/product-list";
	}
}
