package org.cap.service;

import java.util.List;

import org.cap.entities.CartItem;

public interface ICartItemService {

    List<CartItem> fetchAllCartItem(int userId);
    
    CartItem save(CartItem item);
}
