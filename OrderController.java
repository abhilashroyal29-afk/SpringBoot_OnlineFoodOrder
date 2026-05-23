package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Order;
import com.example.demo.service.OrderService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/orders")
public class OrderController {
	
	@Autowired
	private OrderService service;
	
	@GetMapping
	public List<Order> getAll(){
		return service.getAllOrders();
		 
	}
	@GetMapping("/{id}")
	public Order getOrderbyId(@PathVariable int id) {
		return service.getOrderbyId(id);
		
	}
	@PostMapping
	public String add(@Valid @RequestBody Order order) {
		return service.addOrder(order);
		
	}
	@PutMapping("/{id}")
	public Order updateOrder(@PathVariable int id,@Valid @RequestBody Order order) {
		
		return service.updateOrde(id,order);
		
	}
	@DeleteMapping("/{id}")
	
	public String delete(@PathVariable int id) {
		return service.deleteOrder(id);
		
	}
	@PatchMapping("/{id}")
	
	public Order patchOrder(@PathVariable int id,@RequestBody Order partialOrder) {
		return service.patchOrder(id,partialOrder);
		
	}

}
