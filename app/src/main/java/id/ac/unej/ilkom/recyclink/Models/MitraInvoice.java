package id.ac.unej.ilkom.recyclink.Models;

import com.google.gson.annotations.SerializedName;

public class MitraInvoice {
    @SerializedName("id")
    int id;
    @SerializedName("name")
    String name;
    @SerializedName("address")
    String address;
    @SerializedName("date")
    String date;
    @SerializedName("status")
    int status;

    public MitraInvoice(int id, String name, String address, String date, int status) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.date = date;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getDate() {
        return date;
    }

    public int getStatus() {
        return status;
    }
}
