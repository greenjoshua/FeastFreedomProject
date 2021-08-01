package com.minhle.model.kitchen;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable; 
 
public class Item {  
	 
	 private String id;
	 @DynamoDBAttribute(attributeName="itemname")
	 private String name;
	 @DynamoDBAttribute
	 private boolean vegOption;
	 @DynamoDBAttribute
	 private Double price; 
	 
	 
	public Item() {
		super();
		name = "empty";
		vegOption = false;
		price = 0.0;
	}

	public Item(String name, boolean vegOption, Double price) {
		super();
		this.name = name;
		this.vegOption = vegOption;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isVegOption() {
		return vegOption;
	}

	public void setVegOption(boolean vegOption) {
		this.vegOption = vegOption;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return  name+" , " +   vegOption +  " , " + price  ;
	} 

}
