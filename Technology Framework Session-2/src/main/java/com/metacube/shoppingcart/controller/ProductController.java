
/**
 * The Class ProductController.
 *
 * @author Shivam
 * @version 1
 * @date 30-Sep-2017
 * 
 * The Class ProductController.
 * 
 * This class use is responsible to direct the service on right page
 */

package com.metacube.shoppingcart.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.metacube.shoppingcart.facade.ProductFacade;
import com.metacube.shoppingcart.modal.Product;
import com.metacube.shoppingcart.spring.Factory;

@Path("/product")
public class ProductController {

	/** The product facade. */
	ProductFacade productFacade;

	/**
	 * Instantiates a new product controller.
	 */
	public ProductController() {
		productFacade = Factory.getApplicationContext().getBean("productFacade", ProductFacade.class);
	}

	/**
	 * Gets the users.
	 *
	 * @return the users
	 */
	@GET
	@Path("/list")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUsers() {
		return Response.status(Response.Status.OK).entity(productFacade.getAllProducts()).build();

	}

	/**
	 * Gets the product by id.
	 *
	 * @param id the id
	 * @return the product by id
	 */
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getProductById(@PathParam("id") int id) {
		return Response.status(Response.Status.OK).entity(productFacade.getProductById(id)).build();
	}

	/**
	 * Delete product by id.
	 *
	 * @param id the id
	 * @return the response
	 */
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteProductById(@PathParam("id") int id){
		return Response.status(Response.Status.OK).entity(productFacade.deleteProduct(id)).build();
	}

	/**
	 * Adds the product.
	 *
	 * @param product the product
	 * @return the response
	 */
	@POST
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response addProduct(Product product) {
		Response response;
		if(product!=null && product.getName() != null && product.getPrice()>=0) {
			product.setName(product.getName().trim().toUpperCase());
			response = Response.status(Response.Status.OK).entity(productFacade.addProduct(product)).build();
		} else {
			response = Response.status(Response.Status.NOT_ACCEPTABLE).build();
		}
		return response;
	}

	/**
	 * Edits the product.
	 *
	 * @param product the product
	 * @param id the id
	 * @return the response
	 */
	@PUT
	@Path("/edit/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response editProduct(Product product,@PathParam("id") int id) {
		return Response.status(Response.Status.OK).entity(productFacade.editProduct(product,id)).build();
	}

}
