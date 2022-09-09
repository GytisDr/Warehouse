package lt.warehousemanagement.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import lt.warehousemanagement.entities.Order;
import lt.warehousemanagement.services.OrderService;
import lt.warehousemanagement.services.ProductService;

@Controller
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	OrderService orderService;
	
	@Autowired
	ProductService productService;
	
	
	@GetMapping("/all")
	public String getAllOrders(Model model) {
		model.addAttribute("orders", orderService.getAll());
		return "/orders/order-list";
	}
	
	@GetMapping("/review/{id}")
	public String showOrder(@PathVariable("id") int id, Model model) {
		Order order = orderService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid order Id:" + id));
		model.addAttribute("order", order);
		return "/orders/order-review";
	}
	
	@GetMapping("/create")
	public String createOrder(Model model,Order order) {
		model.addAttribute("products", productService.getAll());
		model.addAttribute("order",order);
		return "/orders/create-order";
	}
	
	@PostMapping("/save")
	public String saveOrder(Order order, Model model) {
		orderService.save(order);
		return "redirect:/orders/create";
	}
	
	@GetMapping("/delete/{id}")
	public String deleteOrder(@PathVariable("id") int id, Model model) {
		Order order = orderService.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Invalid supplier Id:" + id));
		orderService.delete(order);
		return "redirect:/orders/all";
	}
	
}
