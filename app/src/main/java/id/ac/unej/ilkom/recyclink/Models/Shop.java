package id.ac.unej.ilkom.recyclink.Models;

import com.google.gson.annotations.SerializedName;

public class Shop {
    @SerializedName("id")
    int id;
    @SerializedName("created_at")
    String created_at;
    @SerializedName("title")
    String title;
    @SerializedName("Status")
    String status;

    public Shop(int id, String created_at, String title, String status) {
        this.id = id;
        this.created_at = created_at;
        this.title = title;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getCreated_at() {
        return created_at;
    }

    public String getTitle() {
        return title;
    }

    public String getStatus() {
        return status;
    }
}
