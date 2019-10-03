package id.ac.unej.ilkom.recyclink.Responses;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Product implements Serializable {

    @SerializedName("thumbnail")
    private String thumbnail;

    @SerializedName("rating")
    private int rating;

    @SerializedName("description")
    private String description;

    @SerializedName("created_at")
    private String createdAt;

    @SerializedName("title")
    private String title;

    @SerializedName("deleted_at")
    private Object deletedAt;

    @SerializedName("category_id")
    private int categoryId;

    @SerializedName("updated_at")
    private String updatedAt;

    @SerializedName("user_id")
    private int userId;

    @SerializedName("price")
    private int price;

    @SerializedName("id")
    private int id;

    @SerializedName("stock")
    private int stock;

    @SerializedName("user")
    private User user;

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public int getRating() {
        return rating;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setDeletedAt(Object deletedAt) {
        this.deletedAt = deletedAt;
    }

    public Object getDeletedAt() {
        return deletedAt;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public int getStock() {
        return stock;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return
                "Product{" +
                        "thumbnail = '" + thumbnail + '\'' +
                        ",rating = '" + rating + '\'' +
                        ",description = '" + description + '\'' +
                        ",created_at = '" + createdAt + '\'' +
                        ",title = '" + title + '\'' +
                        ",deleted_at = '" + deletedAt + '\'' +
                        ",category_id = '" + categoryId + '\'' +
                        ",updated_at = '" + updatedAt + '\'' +
                        ",user_id = '" + userId + '\'' +
                        ",price = '" + price + '\'' +
                        ",id = '" + id + '\'' +
                        ",stock = '" + stock + '\'' +
                        ",user = '" + user + '\'' +
                        "}";
    }
}