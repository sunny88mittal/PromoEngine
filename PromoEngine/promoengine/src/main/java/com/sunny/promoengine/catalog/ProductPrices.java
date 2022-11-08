package com.sunny.promoengine.catalog;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class ProductPrices {

	private static Map<String, Integer> productPrices = new HashMap<String, Integer>();

	static {
		productPrices.put("A", 50);
		productPrices.put("B", 30);
		productPrices.put("C", 20);
		productPrices.put("D", 15);
	}

	public static Map<String, Integer> getProducPrices() {
		return Collections.unmodifiableMap(productPrices);
	}
}
