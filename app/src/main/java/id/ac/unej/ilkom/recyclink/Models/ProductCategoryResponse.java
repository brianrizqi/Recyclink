package id.ac.unej.ilkom.recyclink.Models;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ProductCategoryResponse{

	@SerializedName("data")
	private List<MitraProduct> data;

	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;

	public void setData(List<MitraProduct> data){
		this.data = data;
	}

	public List<MitraProduct> getData(){
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
			"ProductCategoryResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}