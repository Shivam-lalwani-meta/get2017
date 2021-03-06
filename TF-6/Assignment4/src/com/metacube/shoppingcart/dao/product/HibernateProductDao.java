/**
 * @Date 22-October-2017
 * @author Shivam
 * @version 1.0
 * @Project Product implementation using Spring MVC and hibernate
 */
package com.metacube.shoppingcart.dao.product;

import org.springframework.stereotype.Repository;

import com.metacube.shoppingcart.dao.HibernateDao;
import com.metacube.shoppingcart.model.Product;

/**
 * The Class HibernateProductDao.
 */
@Repository("hibernateProductDao")
public class HibernateProductDao extends HibernateDao<Product, Integer>
		implements
			ProductDao {

	/**
	 * Instantiates a new hibernate product dao.
	 */
	public HibernateProductDao() {
		super(Product.class);
	}

}
