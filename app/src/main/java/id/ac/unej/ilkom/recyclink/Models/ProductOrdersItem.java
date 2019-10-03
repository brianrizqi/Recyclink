package id.ac.unej.ilkom.recyclink.Models;

import com.google.gson.annotations.SerializedName;

public class ProductOrdersItem{

	@SerializedName("quantity")
	private int quantity;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("product_id")
	private int productId;

	@SerializedName("invoice_id")
	private int invoiceId;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("deleted_at")
	private Object deletedAt;

	public void setQuantity(int quantity){
		this.quantity = quantity;
	}

	public int getQuantity(){
		return quantity;
	}

	public void setUpdatedAt(String updatedAt){
		this.updatedAt = updatedAt;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public void setProductId(int productId){
		this.productId = productId;
	}

	public int getProductId(){
		return productId;
	}

	public void setInvoiceId(int invoiceId){
		this.invoiceId = invoiceId;
	}

	public int getInvoiceId(){
		return invoiceId;
	}

	public void setCreatedAt(String createdAt){
		this.createdAt = createdAt;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setDeletedAt(Object deletedAt){
		this.deletedAt = deletedAt;
	}

	public Object getDeletedAt(){
		return deletedAt;
	}

	@Override
 	public String toString(){
		return 
			"ProductOrdersItem{" + 
			"quantity = '" + quantity + '\'' + 
			",updated_at = '" + updatedAt + '\'' + 
			",product_id = '" + productId + '\'' + 
			",invoice_id = '" + invoiceId + '\'' + 
			",created_at = '" + createdAt + '\'' + 
			",id = '" + id + '\'' + 
			",deleted_at = '" + deletedAt + '\'' + 
			"}";
		}
}