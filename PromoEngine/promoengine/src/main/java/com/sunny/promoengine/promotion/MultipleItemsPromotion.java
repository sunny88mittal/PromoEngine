package com.sunny.promoengine.promotion;

import java.util.Collections;
import java.util.List;

public class MultipleItemsPromotion implements IPromotion {

	private final List<String> items;

	private final int price;

	public MultipleItemsPromotion(List<String> items, int price) {
		super();
		this.items = Collections.unmodifiableList(items);
		this.price = price;
	}

	@Override
	public int applyPromo(List<String> cartItems) {
		int totalPrice = 0;
		while (cartItems.containsAll(items)) {
			totalPrice += price;
			for (String item : items) {
				cartItems.remove(item);
			}
		}
		return totalPrice;
	}
}
