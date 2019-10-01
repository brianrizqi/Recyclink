package id.ac.unej.ilkom.recyclink.Models;

import com.google.gson.annotations.SerializedName;

public class Category {

	@SerializedName("id")
	private int id;

	@SerializedName("category")
	private String category;

	@SerializedName("title")
	private String title;

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
			"Category{" +
			"id = '" + id + '\'' + 
			",category = '" + category + '\'' + 
			",title = '" + title + '\'' + 
			"}";
		}
}