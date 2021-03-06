/**
 * The Class ProductController.
 *
 * @author Shivam
 * @version 1
 * @date 30-Sep-2017
 * The Enum Status.
 *
 * The Class DefaultProductService.
 * 
 */
package com.metacube.shoppingcart.service;

import com.metacube.shoppingcart.dao.product.ProductDao;
import com.metacube.shoppingcart.enums.Status;
import com.metacube.shoppingcart.modal.Product;

public class DefaultProductService implements ProductService {

	/** The product dao. */
	ProductDao productDao;

	/**
	 * Instantiates a new default product service.
	 *
	 * @param productDao the product dao
	 */
	public DefaultProductService(ProductDao productDao) {
		this.productDao = productDao;
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.service.ProductService#getAllProducts()
	 */
	@Override
	public Iterable<Product> getAllProducts() {
		// TODO Auto-generated method stub
		return productDao.findAll();
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.service.ProductService#getProductById(int)
	 */
	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		return productDao.findOne(id);
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.service.ProductService#addProduct(com.metacube.shoppingcart.modal.Product)
	 */
	@Override
	public Status addProduct(Product entity) {
		// TODO Auto-generated method stub
		return productDao.save(entity);
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.service.ProductService#deleteProduct(int)
	 */
	@Override
	public Status deleteProduct(int id) {
		// TODO Auto-generated method stub
		return productDao.delete(id);
	}

	/* (non-Javadoc)
	 * @see com.metacube.shoppingcart.service.ProductService#editProduct(com.metacube.shoppingcart.modal.Product, int)
	 */
	@Override
	public Status editProduct(Product entity,int id) {
		// TODO Auto-generated method stub
		return productDao.edit(entity,id);
	}

}
