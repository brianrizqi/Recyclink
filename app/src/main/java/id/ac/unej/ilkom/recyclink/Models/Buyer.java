package id.ac.unej.ilkom.recyclink.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Buyer implements Serializable {

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("role_id")
	private int roleId;

	@SerializedName("api_token")
	private String apiToken;

	@SerializedName("name")
	private String name;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("email_verified_at")
	private Object emailVerifiedAt;

	@SerializedName("id")
	private int id;

	@SerializedName("verification_code")
	private String verificationCode;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("email")
	private String email;

	@SerializedName("username")
	private String username;

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setRoleId(int roleId){
		this.roleId = roleId;
	}

	public int getRoleId(){
		return roleId;
	}

	public void setApiToken(String apiToken){
		this.apiToken = apiToken;
	}

	public String getApiToken(){
		return apiToken;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setEmailVerifiedAt(Object emailVerifiedAt){
		this.emailVerifiedAt = emailVerifiedAt;
	}

	public Object getEmailVerifiedAt(){
		return emailVerifiedAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setVerificationCode(String verificationCode){
		this.verificationCode = verificationCode;
	}

	public String getVerificationCode(){
		return verificationCode;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

	@Override
 	public String toString(){
		return 
			"Buyer{" + 
			"updated_at = '" + updatedAt + '\'' + 
			",role_id = '" + roleId + '\'' + 
			",api_token = '" + apiToken + '\'' + 
			",name = '" + name + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",email_verified_at = '" + emailVerifiedAt + '\'' + 
			",id = '" + id + '\'' + 
			",verification_code = '" + verificationCode + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",email = '" + email + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}