package id.ac.unej.ilkom.recyclink.Models;

import com.google.gson.annotations.SerializedName;

public class TrashSelling {

	@SerializedName("thumbnail")
	private String thumbnail;

	@SerializedName("price")
	private int price;

	@SerializedName("id")
	private int id;

	@SerializedName("category")
	private String category;

	@SerializedName("title")
	private String title;

	public void setThumbnail(String thumbnail){
		this.thumbnail = thumbnail;
	}

	public String getThumbnail(){
		return thumbnail;
	}

	public void setPrice(int price){
		this.price = price;
	}

	public int getPrice(){
		return price;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setTitle(String title){
		this.title = title;
	}

	public String getTitle(){
		return title;
	}

	@Override
 	public String toString(){
		return 
			"TrashSelling{" +
			"thumbnail = '" + thumbnail + '\'' + 
			",price = '" + price + '\'' + 
			",id = '" + id + '\'' + 
			",category = '" + category + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}