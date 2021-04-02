package com.ecommerceapp.service;

import java.util.Set;
import java.util.UUID;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerceapp.dto.Purchase;
import com.ecommerceapp.dto.PurchaseResponse;
import com.ecommerceapp.entities.Customer;
import com.ecommerceapp.entities.Order;
import com.ecommerceapp.entities.OrderItem;
import com.ecommerceapp.repos.CustomerRepository;

@Service
public class CheckoutServiceImpl implements CheckoutService {

	@PersistenceContext
	EntityManager em;
	
	@Autowired
	CustomerRepository customerrepo;
	
	
	@Override
	@Transactional
	public PurchaseResponse checkout(Purchase purchase) {
		
		Customer customer = customerrepo.findByEmail(purchase.getCustomer().getEmail());
		
		Order order = purchase.getOrder();
		order.setOrderTrackingNumber(UUID.randomUUID().toString());
		customer.add(order);
		
		Set<OrderItem> items = purchase.getOrderItems();
		items.forEach(item -> order.add(item));
		
		order.setBillingAddress(purchase.getBillingAddress());
		
		order.setShippingAddress(purchase.getBillingAddress());
		
		em.persist(customer);
		
		return new PurchaseResponse(order.getOrderTrackingNumber());
	}

}
