package org.cap.service;

import org.cap.dao.ICartItemDao;
import org.cap.entities.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartItemServiceImpl implements ICartItemService {
    private ICartItemDao dao;

	@Override
	public List<CartItem> fetchAllCartItem(int userId) {
		List<CartItem>list=dao.fetchAllCartItem(userId);
		return list;
	}

	public ICartItemDao getCustomerDao() {
		return dao;
	}

	@Autowired
	public void setCustomerDao(ICartItemDao dao) {
		this.dao = dao;
	}

	@Override
	public CartItem save(CartItem item) {
		 CartItem item1=dao.save(item);
		 return item1;
	}

  
}
