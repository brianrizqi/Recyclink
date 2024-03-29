package id.ac.unej.ilkom.recyclink.Responses;

import com.google.gson.annotations.SerializedName;

public class DefaultResponse {

	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;

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

	@Override
 	public String toString(){
		return 
			"DefaultResponse{" +
			"success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}