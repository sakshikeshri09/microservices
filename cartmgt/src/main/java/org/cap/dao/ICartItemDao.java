package org.cap.dao;



import java.util.List;

import org.cap.entities.CartItem;

public interface ICartItemDao {

     List<CartItem> fetchAllCartItem(int userId);
     
     CartItem save(CartItem item);
}
