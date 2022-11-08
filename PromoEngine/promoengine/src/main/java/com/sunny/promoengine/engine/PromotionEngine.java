package com.sunny.promoengine.engine;

import java.util.List;
import java.util.Map;

import com.sunny.promoengine.promotion.IPromotion;

public class PromotionEngine {

	private List<IPromotion> promotions;

	private Map<String, Integer> productPrices;

	public PromotionEngine(List<IPromotion> promotions, Map<String, Integer> productPrices) {
		super();
		this.promotions = promotions;
		this.productPrices = productPrices;
	}

	public int applyPromotions(List<String> cartItems) {
		int cartPrice = 0;
		for (IPromotion promotion : promotions) {
			cartPrice += promotion.applyPromo(cartItems);
		}

		for (String cartItem : cartItems) {
			cartPrice += productPrices.get(cartItem);
		}

		return cartPrice;
	}
}
