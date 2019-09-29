package id.ac.unej.ilkom.recyclink.Models;

import com.google.gson.annotations.SerializedName;

public class Trash {
    @SerializedName("id")
    int id;
    @SerializedName("img")
    int img;
    @SerializedName("name")
    String name;
    @SerializedName("category")
    String category;
    @SerializedName("price")
    String price;

    public Trash(int id, int img, String name, String category, String price) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public int getImg() {
        return img;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getPrice() {
        return price;
    }
}
