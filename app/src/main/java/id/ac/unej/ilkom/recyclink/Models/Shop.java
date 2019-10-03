package id.ac.unej.ilkom.recyclink.Models;

import java.io.Serializable;
import java.util.List;
import com.google.gson.annotations.SerializedName;

import id.ac.unej.ilkom.recyclink.Responses.ProductOrdersItem;

public class Shop implements Serializable {

	@SerializedName("total_price")
	private int totalPrice;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("product_orders")
	private List<id.ac.unej.ilkom.recyclink.Responses.ProductOrdersItem> productOrders;

	@SerializedName("deleted_at")
	private Object deletedAt;

	@SerializedName("alamat")
	private String alamat;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("user_id")
	private int userId;

	@SerializedName("courier")
	private String courier;

	@SerializedName("payment")
	private Object payment;

	@SerializedName("id")
	private int id;

	@SerializedName("district_id")
	private Object districtId;

	@SerializedName("resi")
	private String resi;

	@SerializedName("status")
	private int status;

	public void setTotalPrice(int totalPrice){
		this.totalPrice = totalPrice;
	}

	public int getTotalPrice(){
		return totalPrice;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setProductOrders(List<id.ac.unej.ilkom.recyclink.Responses.ProductOrdersItem> productOrders){
		this.productOrders = productOrders;
	}

	public List<ProductOrdersItem> getProductOrders(){
		return productOrders;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	public void setAlamat(String alamat){
		this.alamat = alamat;
	}

	public String getAlamat(){
		return alamat;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setUserId(int userId){
		this.userId = userId;
	}

	public int getUserId(){
		return userId;
	}

	public void setCourier(String courier){
		this.courier = courier;
	}

	public String getCourier(){
		return courier;
	}

	public void setPayment(Object payment){
		this.payment = payment;
	}

	public Object getPayment(){
		return payment;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setDistrictId(Object districtId){
		this.districtId = districtId;
	}

	public Object getDistrictId(){
		return districtId;
	}

	public void setResi(String resi){
		this.resi = resi;
	}

	public String getResi(){
		return resi;
	}

	public void setStatus(int status){
		this.status = status;
	}

	public int getStatus(){
		return status;
	}

	@Override
 	public String toString(){
		return 
			"Shop{" +
			"total_price = '" + totalPrice + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",product_orders = '" + productOrders + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			",alamat = '" + alamat + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",user_id = '" + userId + '\'' + 
			",courier = '" + courier + '\'' + 
			",payment = '" + payment + '\'' + 
			",id = '" + id + '\'' + 
			",district_id = '" + districtId + '\'' + 
			",resi = '" + resi + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}