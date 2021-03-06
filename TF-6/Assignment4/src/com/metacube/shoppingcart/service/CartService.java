/**
 * @Date 22-October-2017
 * @author Shivam
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.model.Cart;

/**
 * The Interface CartService.
 */
public interface CartService {
	
	/**
	 * Gets the all.
	 *
	 * @param id the id
	 * @return the all
	 */
	Iterable<Cart> getAll(String id);

	/**
	 * Adds the to cart.
	 *
	 * @param pname the pname
	 * @param price the price
	 * @param productId the product id
	 * @param userId the user id
	 * @return the cart
	 */
	Cart addToCart(String pname, double price, int productId, String userId);

	/**
	 * Checkout.
	 *
	 * @param id the id
	 * @return the boolean
	 */
	Boolean checkout(String id);
}
