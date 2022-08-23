package lt.warehousemanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
	
	@GetMapping("/delete/{id}")
	public String deleteProduct(@PathVariable("id") int id, Model model) {
		Product product = productService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
		productService.delete(product);
		return "redirect:/products/all";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Product product = productService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid product Id:" + id));
		model.addAttribute("product", product);
		return "products/update-product";
	}
	
	@PostMapping("/update/{id}")
	public String updateProduct(@PathVariable("id") int id, Product product, BindingResult result, Model model) {
		if(result.hasErrors()) {
			product.setId(id);
			return "products/update-product";
		}
		productService.save(product);
		return "redirect:/products/all";
	}
}
