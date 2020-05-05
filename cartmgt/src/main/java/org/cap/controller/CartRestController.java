package org.cap.controller;

import org.cap.dto.AddCartItemDto;
import org.cap.dto.CartItemDetailsDto;

import org.cap.dto.ProductDto;
import org.cap.entities.CartItem;
import org.cap.exceptions.CustomerNotFoundException;
import org.cap.service.ICartItemService;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/cartitem") //base url
public class CartRestController {
    private static final Logger Log = LoggerFactory.getLogger(CartRestController.class);

    @Autowired
    ICartItemService service;
    
    @Value("${productservice.baseurl}")
    private String ProductServiceBaseUrl;
 
    public String getProductServiceBaseUrl() {
		return ProductServiceBaseUrl;
	}

	public void setProductServiceBaseUrl(String productServiceBaseUrl) {
		ProductServiceBaseUrl = productServiceBaseUrl;
	}

	@PostMapping("/add")
    public ResponseEntity<CartItem> addItem(@RequestBody AddCartItemDto dto)
    {
		CartItem item =new CartItem();
		item.setUserId(dto.getUserId());
    	item.setProductId(dto.getProductId());
    	item=service.save(item);
    	ResponseEntity<CartItem> response=new ResponseEntity<>(item,HttpStatus.OK);
    	return response;
    	
    }

    public CartItem convertDto(AddCartItemDto dto)
    {
    	CartItem item =new CartItem();
    	
    	item.setUserId(dto.getUserId());
    	item.setProductId(dto.getProductId());
    	return item;
    }
    
    @GetMapping("/userdetail/{id}")
    public ResponseEntity<List<CartItemDetailsDto>> getDetail(@PathVariable("id") int userid)
    {
    	List<CartItem> cartList=service.fetchAllCartItem(userid);
    	List<CartItemDetailsDto> desired=new ArrayList<>();
    	for(CartItem item:cartList)
    	{
    		ProductDto productdto=findById(item.getProductId());
    		CartItemDetailsDto cartitemdetailsdto=getDetails(item, productdto);
    		desired.add(cartitemdetailsdto);
    	}
    	ResponseEntity<List<CartItemDetailsDto>> response=new ResponseEntity<>(desired,HttpStatus.OK);
    	return response;
    	
    }
    
    @Autowired
     private RestTemplate restTemplate;
    
    public ProductDto findById(int id)
    {
    	
    	String url=ProductServiceBaseUrl+"/find/"+id;
    	 ProductDto productdto=restTemplate.getForObject(url,ProductDto.class);
    	 return productdto;
    }
    
    
    
    
    public CartItemDetailsDto getDetails(CartItem item,ProductDto productdto)
    {
    	CartItemDetailsDto cartitemdetailsdto=new CartItemDetailsDto();
    	cartitemdetailsdto.setId(productdto.getId());
    	cartitemdetailsdto.setPrice(productdto.getPrice());
    	cartitemdetailsdto.setProductName(productdto.getProductName());
    	return cartitemdetailsdto;
    	
    }
    
}
