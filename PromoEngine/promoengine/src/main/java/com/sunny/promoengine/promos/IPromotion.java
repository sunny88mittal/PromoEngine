package com.sunny.promoengine.promos;

import java.util.List;
import java.util.Map;


/**
 * Promo Interface
 * @author sunmitta
 *
 */
public interface IPromotion {

	/**
	 * Returns the price of the items on which the promo is applied and removes them from list
	 * @param items Cart Items
	 * @param productPriceMap Items price map
	 * @return price of items on which promo is applied
	 */
	public int applyPromo(List<String> items, Map<String, Integer> productPriceMap);
}
