package id.ac.unej.ilkom.recyclink.Responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import id.ac.unej.ilkom.recyclink.Models.Shop;

public class ShopResponse{

	@SerializedName("data")
	private List<Shop> data;

	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;

	public void setData(List<Shop> data){
		this.data = data;
	}

	public List<Shop> getData(){
		return data;
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

	@Override
 	public String toString(){
		return 
			"ShopResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}