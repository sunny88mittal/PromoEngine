package com.sunny.promoengine.engine;

import java.util.List;
import java.util.Map;

import com.sunny.promoengine.catalog.ProductPrices;
import com.sunny.promoengine.promotion.IPromotion;
import com.sunny.promoengine.promotion.PromotionsProvider;

public class PromotionEngine {

	private static List<IPromotion> promotions = PromotionsProvider.getPromotions();

	private static Map<String, Integer> productPrices = ProductPrices.getProducPrices();

	public static int applyPromotions(List<String> cartItems) {
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
