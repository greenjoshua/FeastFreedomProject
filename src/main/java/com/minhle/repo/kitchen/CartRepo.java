package com.minhle.repo.kitchen;

import java.util.ArrayList;
import java.util.HashMap; 
import java.util.List;
import java.util.Map; 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository; 
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper; 
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBScanExpression;
import com.amazonaws.services.dynamodbv2.model.AttributeValue; 
import com.minhle.model.kitchen.Cart;
@Repository
public class CartRepo { 
	@Autowired
    private DynamoDBMapper dynamoDBMapper; 
	public void saveCart(Cart cart) {
		dynamoDBMapper.save(cart);
	}
 
	public Cart getcartbyname(String name) { 
		Map<String, AttributeValue> eav = new HashMap<String, AttributeValue>();
		eav.put(":name", new AttributeValue().withS(name.toLowerCase()));
		DynamoDBScanExpression scanRequest = new DynamoDBScanExpression()	
														.withFilterExpression("userCartname=:name")
														.withExpressionAttributeValues(eav); 
		List<Cart> list =  dynamoDBMapper.scan(Cart.class, scanRequest);
		if (list.size() == 0) {
			return new Cart();
		}
		return list.get(0);		
	} 
	 
//	public void deleteitem(Integer d,Cart c) {
//		List<String> stringsList = new ArrayList<>(c.getItems());
//		 	stringsList.remove(d); 
//		Cart f = new Cart();
//		f.setCartid(c.getCartid());
//		f.setUserCartname(c.getUserCartname());
//		List<String> foo = new ArrayList<String>(stringsList);
//		f.setItems(foo);
//		 	updateCart(c.getCartid(),f); 
//	} 
	
	 public  void addItemToCart(String ItemUnconverted, String userCartname ) { 
		  Cart cart = getcartbyname(userCartname);
		  cart.getItems().add(ItemUnconverted);
		  dynamoDBMapper.save(cart );
	 } 
}
