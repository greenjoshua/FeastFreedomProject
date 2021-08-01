package com.minhle.model.user; 
import java.util.Collection;
import java.util.UUID;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size; 
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component; 
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTypeConverted;
 

@DynamoDBTable(tableName = "KitchenProviderUser") 
@Component
public class KitchenProviderUser    {

    @DynamoDBHashKey
    @DynamoDBAutoGeneratedKey
	private String id;
    
    @DynamoDBAttribute(attributeName = "Service_Provider_Name")
    @NotNull
    @Size(max = 50)
 
    private String name; 
    
	@DynamoDBAttribute(attributeName = "Email")
    @Email
    @NotNull
    @Size(max = 50)
 
	private String email;
	
    @DynamoDBAttribute(attributeName = "Password")
    @NotNull
    @Size(min = 10,max = 50) 
	private String password; 
    
    @DynamoDBAttribute(attributeName = "VerificationCode")
    private String verificationCode;
    
    @DynamoDBAttribute(attributeName = "VerifyStatus")
    private boolean isVerified;
 
 
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name+ " "+ email + " " + password ;
	}
	public KitchenProviderUser() {
	 
		this.name = "Empty";
		this.email = "Empty";
		this.password = "Empty";
	 
	} 
	public KitchenProviderUser(String id, @NotNull @Size(max = 50) @UniqueElements String name,
			@Email @NotNull @Size(max = 50) @UniqueElements String email,
			@NotNull @Size(min = 10, max = 50) String password ) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password; 
		this.verificationCode = UUID.randomUUID().toString();
		this.isVerified = false;
	}
	
	public String getVerificationCode() {
		return verificationCode;
	}
	public void setVerificationCode(String verificationCode) {
		this.verificationCode = verificationCode;
	}
	public boolean isVerified() {
		return isVerified;
	}
	public void setVerified(boolean isVerified) {
		this.isVerified = isVerified;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	} 
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
 
 
	
	
	 
}

 
