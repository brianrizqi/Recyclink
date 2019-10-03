package id.ac.unej.ilkom.recyclink.Responses;

import java.util.List;
import com.google.gson.annotations.SerializedName;

import id.ac.unej.ilkom.recyclink.Models.TrashHistory;

public class TrashHistoryResponse{

	@SerializedName("data")
	private List<TrashHistory> data;

	@SerializedName("success")
	private int success;

	@SerializedName("message")
	private String message;

	public void setData(List<TrashHistory> data){
		this.data = data;
	}

	public List<TrashHistory> getData(){
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
			"TrashHistoryResponse{" + 
			"data = '" + data + '\'' + 
			",success = '" + success + '\'' + 
			",message = '" + message + '\'' + 
			"}";
		}
}