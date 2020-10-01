package com.capg.go.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.capg.go.cms.exception.CartException;
import com.capg.go.cms.model.Cart;
import com.capg.go.cms.model.Login;
import com.capg.go.cms.model.Product;
import com.capg.go.cms.model.ProductList;
import com.capg.go.cms.service.CartService;

/****************************************************************************************************************************
- File Name        : CartController.java 
- Author           : Srinidhi 
- Creation Date    : 21/09/2020
- Modified Date    : 24/09/2020
- Description      : This Controller class act as an end point to manage the entire CartService
****************************************************************************************************************************/

@CrossOrigin("*")
@RestController
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	RestTemplate restTemplate;

	/****************************************************************************************************************************
	  - Method Name         : getAllProductList
	  - Return Type         : productList
	  - End Point Url       : /getallproducts
	  - Request Method Type : GetMapping 
	  - Author              : Srinidhi
	  - Creation Date       : 22/09/2020
	  - Description         : Getting the product list from the database
	 ****************************************************************************************************************************/
	
	@GetMapping("/getallproducts")
	public ResponseEntity<List<Product>> getAllProductList() {
		ResponseEntity<ProductList> productList = restTemplate.getForEntity("http://localhost:7777/product/all",
				ProductList.class);
		List<Product> list = productList.getBody().getList();

		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	/****************************************************************************************************************************
	  - Method Name         : searchProductList
	  - Return Type         : productdetails
	  - End Point Url       : /searchproducts/{pname}
	  - Request Method Type : GetMapping 
	  - Author              : Srinidhi
	  - Creation Date       : 22/09/2020
	  - Description         : Getting the product details from the database by product name
	 ****************************************************************************************************************************/
	
	@GetMapping("/searchproducts/{pname}")
	public ResponseEntity<List<Product>> searchProductList(@PathVariable("pname") String productName) {
		ResponseEntity<ProductList> productList = restTemplate
				.getForEntity("http://localhost:7777/product/name/" + productName, ProductList.class);
		List<Product> list = productList.getBody().getList();

		return new ResponseEntity<>(list, HttpStatus.OK);
	}

	/****************************************************************************************************************************
	  - Method Name         : findAllCarts
	  - Return Type         : cartList
	  - End Point Url       : /cart/all
	  - Request Method Type : GetMapping 
	  - Author              : Srinidhi
	  - Creation Date       : 21/09/2020
	  - Description         : Getting the cart list from the database
	 ****************************************************************************************************************************/
	
	@GetMapping("/cart/all")
	public ResponseEntity<List<Cart>> findAllCarts() throws CartException {

		List<Cart> list = cartService.viewAllCarts();

		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	/****************************************************************************************************************************
	  - Method Name         : addProduct
	  - Input Parameters    : Cart cart
	  - End Point Url       : /cart/add
	  - Request Method Type : PostMapping 
	  - Author              : Srinidhi 
	  - Creation Date       : 21/09/2020
	  - Description         : Adding the product details in to the cart
	 ****************************************************************************************************************************/
	
	@PostMapping("/cart/add")
	public ResponseEntity<Cart> addproduct(@RequestBody Cart cart) throws CartException {

		Cart cart1 = cartService.addProductToCart(cart);

		return new ResponseEntity<>(cart1, HttpStatus.OK);
	}

	/****************************************************************************************************************************
	  - Method Name         : updateCart
	  - Input Parameters    : Cart cart
	  - End Point Url       : /cart/update
	  - Request Method Type : PutMapping 
	  - Author              : Srinidhi 
	  - Creation Date       : 21/09/2020
	  - Description         : Updating the cart details present in the database
	 ****************************************************************************************************************************/
	
	@PutMapping("/cart/update")
	public ResponseEntity<Cart> updateCartItems(@RequestBody Cart cart) throws CartException {

		Cart cart1 = cartService.updateCart(cart);

		return new ResponseEntity<>(cart1, HttpStatus.OK);
	}

	/****************************************************************************************************************************
	  - Method Name         : deleteCartById
	  - Input Parameters    : cartId
	  - Return Type         : boolean
	  - End Point Url       : /cart/delete/{cid} 
	  - Request Method Type : DeleteMapping 
	  - Author              : Srinidhi
	  - Creation Date       : 21/09/2020
	  - Description         : Deleting the cart details from the database
	 ****************************************************************************************************************************/
	
	@DeleteMapping("/cart/delete/{cid}")
	public ResponseEntity<Cart> deleteCartById(@PathVariable("cid") int cartId) throws CartException {

		Cart cart = cartService.deleteCartByCartId(cartId);

		return new ResponseEntity<>(cart, HttpStatus.OK);
	}


	/****************************************************************************************************************************
	  - Method Name         : findCartById
	  - Input Parameters    : cartId
	  - Return Type         : cartdetails
	  - End Point Url       : /cart/get/{cid} 
	  - Request Method Type : GetMapping 
	  - Author              : Srinidhi
	  - Creation Date       : 21/09/2020
	  - Description         : Getting the cart details from the database
	 ****************************************************************************************************************************/

	@GetMapping("/cart/get/{cid}")
	public ResponseEntity<Cart> findCartById(@PathVariable("cid") int cartId) throws CartException {

		Cart cart = cartService.findCartByCartId(cartId);

		return new ResponseEntity<>(cart, HttpStatus.OK);
	}

	/****************************************************************************************************************************
	  - Method Name         : login
	  - Input Parameters    : username and userpassword
	  - Return Type         : logindetails
	  - End Point Url       : /cart/login/{user}/{pass}
	  - Request Method Type : GetMapping 
	  - Author              : Srinidhi
	  - Creation Date       : 22/09/2020
	  - Description         : Getting the login details from the database
	 ****************************************************************************************************************************/
	
	@GetMapping("/cart/login/{user}/{pass}")
	public ResponseEntity<Login> login(@PathVariable("user") String user, @PathVariable("pass") String pass) {

		return restTemplate.getForEntity("http://localhost:9090/login/validate/" + user + "/" + pass, Login.class);
	}

	/****************************************************************************************************************************
	  - Method Name         : signUp
	  - Input Parameters    : enter details
	  - End Point Url       : /cart/signup
	  - Request Method Type : PostMapping 
	  - Author              : Srinidhi 
	  - Creation Date       : 22/09/2020
	  - Description         : creating login
	 ****************************************************************************************************************************/
	
	@PostMapping("/cart/signup")
	public ResponseEntity<Login> signUp(@RequestBody Login login) {

		return restTemplate.postForEntity("http://localhost:9090/login", login, Login.class);
	}

}
