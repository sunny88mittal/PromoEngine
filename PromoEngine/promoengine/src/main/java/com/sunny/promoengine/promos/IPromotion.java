package com.sunny.promoengine.promos;

import java.util.List;
import java.util.Map;


/**
 * Promotion Interface
 * @author sunmitta
 *
 */
public interface IPromotion {

	/**
	 * Returns the price of the items on which the promotion is applied and removes them from list
	 * @param items Cart Items
	 * @param productPriceMap Items price map
	 * @return price of items on which promotion is applied
	 */
	public int applyPromo(List<String> items, Map<String, Integer> productPriceMap);
}
