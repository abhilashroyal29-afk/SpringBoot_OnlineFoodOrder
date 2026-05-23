package com.example.demo.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
	
	private int orderId;
	@NotBlank(message = "customer name is required")
	private String customerName;
	@NotBlank(message = "Food item is required")
	private String foodItem;
	@Min(value = 1,message ="Quantity must be atlest 1")
	private int quantity;
	@NotNull(message = "Price is Required")
	private double price;

}
