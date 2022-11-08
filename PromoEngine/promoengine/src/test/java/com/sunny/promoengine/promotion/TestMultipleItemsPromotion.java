package com.sunny.promoengine.promotion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestMultipleItemsPromotion {

	private IPromotion multiItemsPromotion;

	@Before
	public void setUp() {
		multiItemsPromotion = new MultipleItemsPromotion(Arrays.asList("B", "C"), 30);
	}

	@Test
	public void TestCartWithNoPromoItems() {
		List<String> cartItems = Arrays.asList("A", "A", "A", "A", "D");
		List<String> cartItemsCopy = Collections.unmodifiableList(cartItems);
		int price = multiItemsPromotion.applyPromo(cartItems);
		Assert.assertEquals(0, price);
		Assert.assertTrue(cartItems.equals(cartItemsCopy));
	}

	@Test
	public void TestCartWithAllItemsEligibleForPromotion() {
		List<String> cartItems = Arrays.asList("B", "C", "B", "C");
		List<String> cartItemsCopy = new ArrayList<String>();
		cartItemsCopy.addAll(cartItems);

		int price = multiItemsPromotion.applyPromo(cartItemsCopy);
		List<String> remainingCartItems = Arrays.asList();

		Assert.assertEquals(60, price);
		Assert.assertTrue(remainingCartItems.equals(cartItemsCopy));
	}

	@Test
	public void TestCartWithSomesItemsEligibleForPromotion() {
		List<String> cartItems = Arrays.asList("B", "C", "B", "A", "A");
		List<String> cartItemsCopy = new ArrayList<String>();
		cartItemsCopy.addAll(cartItems);

		int price = multiItemsPromotion.applyPromo(cartItemsCopy);
		List<String> remainingCartItems = Arrays.asList("B", "A", "A");

		Assert.assertEquals(price, 30);
		Assert.assertTrue(remainingCartItems.equals(cartItemsCopy));
	}

	@Test
	public void TestCartWithMultipleItemSetsEligibleForPromotion() {
		List<String> cartItems = Arrays.asList("B", "C", "D", "B", "C", "A", "A");
		List<String> cartItemsCopy = new ArrayList<String>();
		cartItemsCopy.addAll(cartItems);

		int price = multiItemsPromotion.applyPromo(cartItemsCopy);
		List<String> remainingCartItems = Arrays.asList("D", "A", "A");

		Assert.assertEquals(price, 60);
		Assert.assertTrue(remainingCartItems.equals(cartItemsCopy));
	}
}
