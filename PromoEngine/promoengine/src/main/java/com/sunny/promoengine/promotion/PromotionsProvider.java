package com.sunny.promoengine.promotion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PromotionsProvider {

	public static List<IPromotion> getPromotions() {
		List<IPromotion> promotions = new ArrayList<IPromotion>();

		IPromotion promotionOnItemA = new NItemsPromotion("A", 3, 130);
		IPromotion promotionOnItemB = new NItemsPromotion("B", 2, 45);
		IPromotion promotionOnItemCAndD = new MultipleItemsPromotion(Arrays.asList("C", "D"), 30);

		promotions.add(promotionOnItemA);
		promotions.add(promotionOnItemB);
		promotions.add(promotionOnItemCAndD);

		return promotions;
	}
}
