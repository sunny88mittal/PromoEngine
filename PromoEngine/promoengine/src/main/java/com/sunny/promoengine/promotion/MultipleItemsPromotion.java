package com.sunny.promoengine.promotion;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class MultipleItemsPromotion implements IPromotion {

	private final List<String> items;

	private final int price;

	public MultipleItemsPromotion(List<String> items, int price) {
		this.items = Collections.unmodifiableList(items);
		this.price = price;
	}

	@Override
	public int applyPromo(List<String> items, Map<String, Integer> productPriceMap) {
		// TODO Auto-generated method stub
		return 0;
	}
}
