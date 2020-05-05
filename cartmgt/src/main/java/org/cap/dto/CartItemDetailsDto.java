package org.cap.dto;

/**
 * contains info of customer and product
 */
public class CartItemDetailsDto {
   
	   private int  id;
	   
	   private double price;
	   
	   private String productName;

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}



	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}


	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}


}
