package org.cap.dao;


import org.cap.entities.CartItem;
import org.cap.exceptions.CustomerNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class CartItemDaoImpl implements ICartItemDao {
    private Map<Integer, CartItem> store = new HashMap<>();

	@Override
	public List<CartItem> fetchAllCartItem(int userId) {
		Collection<CartItem> item=store.values();
		List<CartItem> cartlist=new ArrayList<>();
		
		for(CartItem citem:item)
		{//matching the user id  of user and of cart
			if(citem.getUserId()==userId) {
				cartlist.add(citem);
			}
		}
		return cartlist;
		
		
	}

	@Override
	public CartItem save(CartItem item) {
		
		int id=generateId();
		item.setCartId(id);
		store.put(item.getCartId(),item);
		// TODO Auto-generated method stub
		return item;
	}
	
	private int generatedId;
	
	public int generateId()
	{
		generatedId++;
		return generatedId;
	}

}
