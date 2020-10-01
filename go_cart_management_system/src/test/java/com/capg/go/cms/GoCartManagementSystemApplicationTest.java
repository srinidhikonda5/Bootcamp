package com.capg.go.cms;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import com.capg.go.cms.dao.CartDao;
import com.capg.go.cms.exception.CartException;
import com.capg.go.cms.model.Cart;
import com.capg.go.cms.service.CartService;
import com.capg.go.cms.service.CartServiceImpl;

/****************************************************************************************************************************
- File Name        : GoCartManagementSystemApplicationTest.java 
- Author           : Srinidhi 
- Creation Date    : 20/09/2020
- Modified Date    : 23/09/2020
****************************************************************************************************************************/
@SpringBootTest
class GoCartManagementSystemApplicationTest {

	@Autowired
	CartDao cartDao;

	@Autowired
	CartService cartService;
	
	@MockBean
    private CartServiceImpl service;

	@Test
	void testViewAllCarts() throws CartException {
		List<Cart> list = cartDao.viewAllCarts();
		assertTrue(list.size() > 0);
	}
	
	@Test
	void testFindCartExistById() throws CartException {
		Cart cart = cartDao.findCartByCartId(44);
		assertNotNull(cart);

	}

	@Test
	void testFindCartNotExist() throws CartException {

		assertThrows(CartException.class, () -> cartDao.findCartByCartId(210));
	}



	@Test
	public void testremoveCartItem() throws CartException {
		 service.deleteCartByCartId(12);
		 verify(service,times(1)).deleteCartByCartId(12);
	}

}











//@Test
//void testDeleteCartNotExistById() throws CartException {
//	assertThrows(CartException.class, () -> cartService.deleteCartByCartId(500));
//}