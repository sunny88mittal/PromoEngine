package com.sunny.promoengine.engine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.sunny.promoengine.catalog.ProductPrices;
import com.sunny.promoengine.promotion.PromotionsProvider;

import junit.framework.Assert;

public class TestPromotionEngine {

	private PromotionEngine promotionEngine;

	@Before
	public void setUp() {
		promotionEngine = new PromotionEngine(PromotionsProvider.getPromotions(), ProductPrices.getProducPrices());
	}

	@Test
	public void testForNoPromotions() {
		List<String> cartItems = Arrays.asList("A", "B", "C");
		int price = promotionEngine.applyPromotions(cartItems);
		Assert.assertEquals(100, price);
	}

	@Test
	public void testForNItemPromotion() {
		List<String> cartItems = Arrays.asList("A", "A", "A", "A", "A", "B", "B", "B", "B", "B", "C");
		List<String> cartItemsCopy = new ArrayList<String>();
		cartItemsCopy.addAll(cartItems);
		int price = promotionEngine.applyPromotions(cartItemsCopy);
		Assert.assertEquals(370, price);
	}

	@Test
	public void testForAllPromotions() {
		List<String> cartItems = Arrays.asList("A", "A", "A", "B", "B", "B", "B", "B", "C", "D");
		List<String> cartItemsCopy = new ArrayList<String>();
		cartItemsCopy.addAll(cartItems);
		int price = promotionEngine.applyPromotions(cartItemsCopy);
		Assert.assertEquals(280, price);
	}
}
