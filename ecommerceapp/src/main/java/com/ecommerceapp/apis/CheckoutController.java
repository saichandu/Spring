package com.ecommerceapp.apis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerceapp.dto.Purchase;
import com.ecommerceapp.dto.PurchaseResponse;
import com.ecommerceapp.service.CheckoutServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/checkout")
public class CheckoutController {
	
	@Autowired
	CheckoutServiceImpl checkoutService;

	@PostMapping("/purchase")
	public PurchaseResponse placeOrder(@RequestBody Purchase purchase) {
		return checkoutService.checkout(purchase);
	}
}
