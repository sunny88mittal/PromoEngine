package com.sunny.promoengine.promotion;

import java.util.List;

/**
 * Promotion Interface
 * 
 * @author sunmitta
 *
 */
public interface IPromotion {

	/**
	 * Returns the price of the items on which the promotion is applied and removes
	 * them from list
	 * 
	 * @param cartItems Cart Items
	 * @return price of items on which promotion is applied
	 */
	public int applyPromo(List<String> cartItems);
}
