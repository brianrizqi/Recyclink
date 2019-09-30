package id.ac.unej.ilkom.recyclink.Responses;

import com.google.gson.annotations.SerializedName;

import id.ac.unej.ilkom.recyclink.Models.User;

public class LoginResponse {

	@SerializedName("role")
	private int role;

	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;

	@SerializedName("user")
	private User user;

	@SerializedName("token")
	private String token;

	public void setRole(int role){
		this.role = role;
	}

	public int getRole(){
		return role;
	}

	public void setSuccess(int success){
		this.success = success;
	}

	public int getSuccess(){
		return success;
	}

	public void setMessage(String message){
		this.message = message;
	}

	public String getMessage(){
		return message;
	}

	public void setUser(User user){
		this.user = user;
	}

	public User getUser(){
		return user;
	}

	public void setToken(String token){
		this.token = token;
	}

	public String getToken(){
		return token;
	}

	@Override
 	public String toString(){
		return 
			"LoginResponse{" +
			"role = '" + role + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			",user = '" + user + '\'' + 
			",token = '" + token + '\'' + 
			"}";
		}
}