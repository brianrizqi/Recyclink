package id.ac.unej.ilkom.recyclink.Models;

public class DashboardPopuler {
    int id, img;
    String title, price, rating;

    public DashboardPopuler(int id, int img, String title, String price, String rating) {
        this.id = id;
        this.img = img;
        this.title = title;
        this.price = price;
        this.rating = rating;
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
}
