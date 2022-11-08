package com.sunny.promoengine.promotion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class TestNItemsPromotion {

	private IPromotion nItemsPromotion;

	@Before
	public void setUp() {
		nItemsPromotion = new NItemsPromotion("A", 3, 130);
	}

	@Test
	public void testCartWithNoPromoItems() {
		List<String> cartItems = Arrays.asList("B", "C", "D", "B", "B");
		List<String> cartItemsCopy = Collections.unmodifiableList(cartItems);
		int price = nItemsPromotion.applyPromo(cartItems);
		Assert.assertEquals(price, 0);
		Assert.assertTrue(cartItems.equals(cartItemsCopy));
	}

	@Test
	public void testCartWithAllItemsEligibleForPromotion() {
		List<String> cartItems = Arrays.asList("A", "A", "A");
		List<String> cartItemsCopy = new ArrayList<String>();
		cartItemsCopy.addAll(cartItems);

		int price = nItemsPromotion.applyPromo(cartItemsCopy);
		List<String> remainingCartItems = Arrays.asList();

		Assert.assertEquals(price, 130);
		Assert.assertTrue(remainingCartItems.equals(cartItemsCopy));
	}

	@Test
	public void testCartWithSomesItemsEligibleForPromotion() {
		List<String> cartItems = Arrays.asList("A", "A", "D", "A", "A");
		List<String> cartItemsCopy = new ArrayList<String>();
		cartItemsCopy.addAll(cartItems);

		int price = nItemsPromotion.applyPromo(cartItemsCopy);
		List<String> remainingCartItems = Arrays.asList("D", "A");

		Assert.assertEquals(price, 130);
		Assert.assertTrue(remainingCartItems.equals(cartItemsCopy));
	}

	@Test
	public void testCartWithMultipleItemSetsEligibleForPromotion() {
		List<String> cartItems = Arrays.asList("A", "A", "D", "A", "A", "A", "A");
		List<String> cartItemsCopy = new ArrayList<String>();
		cartItemsCopy.addAll(cartItems);

		int price = nItemsPromotion.applyPromo(cartItemsCopy);
		List<String> remainingCartItems = Arrays.asList("D");

		Assert.assertEquals(price, 260);
		Assert.assertTrue(remainingCartItems.equals(cartItemsCopy));
	}

	@Test
	public void TestCartWithItemsLessThanQuantityEligibleForPromotion() {
		List<String> cartItems = Arrays.asList("A", "A", "D");
		List<String> cartItemsCopy = new ArrayList<String>();
		cartItemsCopy.addAll(cartItems);

		int price = nItemsPromotion.applyPromo(cartItemsCopy);
		List<String> remainingCartItems = Arrays.asList("A", "A", "D");

		Assert.assertEquals(price, 0);
		Assert.assertTrue(remainingCartItems.equals(cartItemsCopy));
	}
}
