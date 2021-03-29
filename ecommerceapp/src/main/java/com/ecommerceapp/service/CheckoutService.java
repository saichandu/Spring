package com.ecommerceapp.service;

import com.ecommerceapp.dto.Purchase;
import com.ecommerceapp.dto.PurchaseResponse;

public interface CheckoutService {
	PurchaseResponse checkout(Purchase purchase);
}
