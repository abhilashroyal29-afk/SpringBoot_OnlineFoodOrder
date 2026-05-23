package com.example.demo.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.model.Order;

import jakarta.validation.Valid;

@Service
public class OrderService {
	
	 private List<Order> olist = new ArrayList<>(Arrays.asList(
			 
			 new Order(1,"Abhi","Pizza",2,250.0),
			 new Order(2,"Rahul","Burger",1,120.0),
			 new Order(3,"Naveen","Sandwich",3,300.0)
			 
			 ));

	 public List<Order> getAllOrders() {
		// TODO Auto-generated method stub
		return olist;
	 }

	 public Order getOrderbyId(int id) {
		// TODO Auto-generated method stub
		 for(Order o:olist) {
			 if(o.getOrderId() ==id) {
				 return o;
				 
			 }
		 }
		return null;
	 }

	 public String addOrder(@Valid Order order) {
		// TODO Auto-generated method stub
		 olist.add(order);
		return "Order Added";
	 }

	 public Order updateOrde(int id, @Valid Order order) {
		// TODO Auto-generated method stub
		 for(Order o:olist) {
				if(o.getOrderId()==id) {
					o.setCustomerName(order.getCustomerName());
					o.setFoodItem(order.getFoodItem());
					o.setPrice(order.getPrice());
					return o;
				}
			}
		return null;
	 }

	 public String deleteOrder(int id) {
		// TODO Auto-generated method stub
		 for(Order o:olist) {
			 if(o.getOrderId()==id) {
				 
				 olist.remove(o);
				 return "Deleted sucessfully ";
			 }
		 }
		return "Order Not found";
	 }

		 public Order patchOrder(int id, Order partialOrder) {
			    for (Order o : olist) {
			        if (o.getOrderId() == id) {
			            
			           
			            if (partialOrder.getCustomerName() != null) {
			                o.setCustomerName(partialOrder.getCustomerName());
			            }
			            
			            // 
			            if (partialOrder.getFoodItem() != null) {
			                o.setFoodItem(partialOrder.getFoodItem());
			            }
			            
			            // 
			            if (partialOrder.getPrice() > 0.0) {
			                o.setPrice(partialOrder.getPrice());
			            }
			            
			            return o; 
			        }
			    }
			    return null; 
			
	 }

}
