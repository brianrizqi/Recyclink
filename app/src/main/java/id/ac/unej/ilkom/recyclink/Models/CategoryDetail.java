package id.ac.unej.ilkom.recyclink.Models;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class CategoryDetail implements Serializable {
    @SerializedName("id")
    int id;
    @SerializedName("img")
    int img;
    @SerializedName("name")
    String title;
    @SerializedName("price")
    String price;
    @SerializedName("rating")
    String rating;
    @SerializedName("description")
    String desc;
    @SerializedName("user")
    String user;

    public CategoryDetail(int id, int img, String title, String price, String rating, String desc, String user) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.price = price;
        this.rating = rating;
        this.desc = desc;
        this.user = user;
    }

    public int getId() {
        return id;
    }

    public int getImg() {
        return img;
    }

    public String getTitle() {
        return title;
    }

    public String getPrice() {
        return price;
    }

    public String getRating() {
        return rating;
    }

    public String getDesc() {
        return desc;
    }

    public String getUser() {
        return user;
    }
}
