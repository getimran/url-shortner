package com.imran.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imran.model.Product;
import com.imran.service.PhoneShopService;

@RestController
public class PhoneShopController {

	private final PhoneShopService phoneShopService;

	@Autowired
	public PhoneShopController(PhoneShopService phoneShopService) {
		this.phoneShopService = phoneShopService;
	}

	@RequestMapping(value = "/getDiscount", method = RequestMethod.GET, produces = "application/json")
	public Product getQuestions(@RequestParam(required = true) String type) {

		Product product = new Product();
		product.setType(type);

		phoneShopService.getProductDiscount(product);

		return product;
	}

}
