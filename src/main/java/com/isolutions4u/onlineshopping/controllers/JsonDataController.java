package com.isolutions4u.onlineshopping.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isolutions4u.onlineshopping.model.Product;
import com.isolutions4u.onlineshopping.model.User;
import com.isolutions4u.onlineshopping.service.ProductService;
import com.isolutions4u.onlineshopping.service.UserService;

@RestController
@RequestMapping("/json/data")
public class JsonDataController {

	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@Autowired
	@Qualifier("userService")
	private UserService userService;

	@GetMapping("/all/products")
	public List<Product> getAllProducts() {
		List<Product> products = productService.findAllProducts();
		return products;

	}
	
	@GetMapping("/admin/all/products")
	public List<Product> getAllProductsForAdmin() {
		List<Product> products = productService.findAllProductsForAdmin();
		return products;

	}
	
	@GetMapping("/admin/all/records")
	public List<Product> getAllRecordsForAdmin() {
		List<Product> products = productService.findAllProductsForAdmin();
		List<Product> returnProducts = new ArrayList<Product>();
		for(Product thisProduct:products) {
			User user = userService.findUserByEmail(thisProduct.getSupplier());
			
			  if(user!=null && user.getRole().equals("SUPPLIER")) {
			   returnProducts.add(thisProduct); 
			   }
			 
			returnProducts.add(thisProduct);
		}
		return returnProducts;

	}
	
	@GetMapping("/admin/all/retailers")
	public List<User> getAllRetailers() {
		List<User> retailers = userService.findAllRetailers("SUPPLIER");
		return retailers;

	}

	@GetMapping("/category/{categoryId}/products")
	public List<Product> getProductsByCategory(@PathVariable("categoryId") int categoryId) {
		List<Product> products = productService.findProductByCategoryId(categoryId);
		return products;

	}

}
