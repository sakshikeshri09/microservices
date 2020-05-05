package org.cap.entities;

import java.util.List;
import java.util.Set;

public class CartItem {

    private int cartId;

    private int  productId;

  private int userId;

public int getCartId() {
	return cartId;
}

public void setCartId(int cartId) {
	this.cartId = cartId;
}

public int getProductId() {
	return productId;
}

public void setProductId(int productId) {
	this.productId = productId;
}

public int getUserId() {
	return userId;
}

public void setUserId(int userId) {
	this.userId = userId;
}
}
