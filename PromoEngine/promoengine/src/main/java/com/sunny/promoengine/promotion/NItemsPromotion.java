package com.sunny.promoengine.promotion;

import java.util.List;
import java.util.Map;

public class NItemsPromotion implements IPromotion {

	private final String item;

	private final int quantity;

	private final int price;

	public NItemsPromotion(String item, int quantity, int price) {
		super();
		this.item = item;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public int applyPromo(List<String> items, Map<String, Integer> productPriceMap) {
		// TODO Auto-generated method stub
		return 0;
	}
}
