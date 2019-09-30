package id.ac.unej.ilkom.recyclink.Models;

import com.google.gson.annotations.SerializedName;

public class TrashSelling {
    @SerializedName("id")
    int id;
    @SerializedName("img")
    int img;
    @SerializedName("name")
    String name;
    @SerializedName("category")
    String category;
    @SerializedName("weight")
    String weight;

    public TrashSelling(int id, int img, String name, String category, String weight) {
        this.id = id;
        this.img = img;
        this.name = name;
        this.category = category;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public int getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getCategory() {
        return category;
    }

    public String getWeight() {
        return weight;
    }
}
