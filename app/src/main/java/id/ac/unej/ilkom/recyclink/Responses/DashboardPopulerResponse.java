package id.ac.unej.ilkom.recyclink.Responses;

import java.util.List;

import com.google.gson.annotations.SerializedName;

import id.ac.unej.ilkom.recyclink.Models.DashboardPopuler;

public class DashboardPopulerResponse {

    @SerializedName("data")
    private List<DashboardPopuler> data;

    @SerializedName("success")
    private int success;

    @SerializedName("message")
    private String message;

    public void setData(List<DashboardPopuler> data) {
        this.data = data;
    }

    public List<DashboardPopuler> getData() {
        return data;
    }

    public void setSuccess(int success) {
        this.success = success;
    }

    public int getSuccess() {
        return success;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return
                "DashboardPopulerResponse{" +
                        "data = '" + data + '\'' +
                        ",success = '" + success + '\'' +
                        ",message = '" + message + '\'' +
                        "}";
    }
}