package lt.warehousemanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import lt.warehousemanagement.entities.Supplier;
import lt.warehousemanagement.services.SupplierService;

@Controller
@RequestMapping("/suppliers")
public class SupplierController {
	
	@Autowired
	SupplierService supplierService;
	
	@PostMapping("/save")
	public String saveSupplier(Supplier supplier) {
		supplierService.save(supplier);
		return "redirect:/suppliers/create";
	}
		
	@GetMapping("/create")
	public String showCreateForm(Supplier supplier) {
		return "/suppliers/add-supplier";
	}
		
	@GetMapping("/all")
	public String getAllSuppliers(Model model) {
		model.addAttribute("suppliers", supplierService.getAll());
		return "/suppliers/supplier-list";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteSupplier(@PathVariable("id") int id, Model model) {
		Supplier supplier = supplierService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid supplier Id:" + id));
		supplierService.delete(supplier);
		return "redirect:/suppliers/all";
	}
	
	@GetMapping("/edit/{id}")
	public String showUpdateForm(@PathVariable("id") int id, Model model) {
		Supplier supplier = supplierService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid supplier Id:" + id));
		model.addAttribute("supplier", supplier);
		return "suppliers/update-supplier";
	}
	
	@PostMapping("/update/{id}")
	public String updateSupplier(@PathVariable("id") int id, Supplier supplier, BindingResult result, Model model) {
		if(result.hasErrors()) {
			supplier.setId(id);
			return "suppliers/update-supplier";
		}
		supplierService.save(supplier);
		return "redirect:/suppliers/all";
	}
}
