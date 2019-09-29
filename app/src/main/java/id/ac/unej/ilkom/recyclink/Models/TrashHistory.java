package id.ac.unej.ilkom.recyclink.Models;

import com.google.gson.annotations.SerializedName;

public class TrashHistory {
    @SerializedName("id")
    int id;
    @SerializedName("created_at")
    String date;
    @SerializedName("weight")
    String weight;
    @SerializedName("price")
    String price;

    public TrashHistory(int id, String date, String weight, String price) {
        this.id = id;
        this.date = date;
        this.weight = weight;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getWeight() {
        return weight;
    }

    public String getPrice() {
        return price;
    }
}
