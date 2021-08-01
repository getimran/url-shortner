package com.imran.service;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imran.model.Product;

@Service
public class PhoneShopService {

	private final KieContainer kieContainer;

	@Autowired
	public PhoneShopService(KieContainer kieContainer) {
		this.kieContainer = kieContainer;
	}

	public Product getProductDiscount(Product product) {
		System.setProperty("java.version", "1.8");
		KieSession kieSession = kieContainer.newKieSession("rulesSession");
		kieSession.insert(product);
		kieSession.fireAllRules();
		kieSession.dispose();
		return product;
	}
}