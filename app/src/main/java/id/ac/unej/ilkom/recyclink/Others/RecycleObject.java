package id.ac.unej.ilkom.recyclink.Others;

import com.google.gson.annotations.SerializedName;

public class RecycleObject {

    @SerializedName("quantity")
    private int quantity;

    @SerializedName("category_id")
    private int categoryId;

    public RecycleObject(int quantity, int categoryId) {
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getCategoryId() {
        return categoryId;
    }

    @Override
    public String toString() {
        return
                "RecycleObject{" +
                        "quantity = '" + quantity + '\'' +
                        ",category_id = '" + categoryId + '\'' +
                        "}";
    }
}