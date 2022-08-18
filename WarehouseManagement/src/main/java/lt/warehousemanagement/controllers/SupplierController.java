package lt.warehousemanagement.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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
}
