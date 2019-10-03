package id.ac.unej.ilkom.recyclink.Service;


import id.ac.unej.ilkom.recyclink.Models.ProductCategoryResponse;
import id.ac.unej.ilkom.recyclink.Responses.CategoryResponse;
import id.ac.unej.ilkom.recyclink.Responses.DashboardPopulerResponse;
import id.ac.unej.ilkom.recyclink.Responses.DefaultResponse;
import id.ac.unej.ilkom.recyclink.Responses.LoginResponse;
import id.ac.unej.ilkom.recyclink.Responses.MitraInvoiceResponse;
import id.ac.unej.ilkom.recyclink.Responses.MitraProductResponse;
import id.ac.unej.ilkom.recyclink.Responses.ShopResponse;
import id.ac.unej.ilkom.recyclink.Responses.TrashHistoryResponse;
import id.ac.unej.ilkom.recyclink.Responses.TrashSellingResponse;
import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface APIService {
    @FormUrlEncoded
    @POST("register")
    Call<DefaultResponse> register(
            @Field("name") String name,
            @Field("email") String email,
            @Field("password") String password,
            @Field("username") String username
    );

    @FormUrlEncoded
    @POST("login")
    Call<LoginResponse> login(
            @Field("password") String password,
            @Field("username") String username
    );

    @FormUrlEncoded
    @POST("order")
    Call<DefaultResponse> order(
            @Header("token") String token,
            @Field("product_id") int product_id,
            @Field("alamat") String address,
            @Field("quantity") int quantity,
            @Field("courier") String courier,
            @Field("payment") String payment
    );

    @GET("fav-products")
    Call<DashboardPopulerResponse> dashboardPopuler(
            @Header("token") String token
    );

    @GET("new-products")
    Call<DashboardPopulerResponse> dashboardRekomend(
            @Header("token") String token
    );

    @FormUrlEncoded
    @POST("get-product-by-category")
    Call<ProductCategoryResponse> productCategory(
            @Header("token") String token,
            @Field("category_id") String category
    );

    @GET("my-products")
    Call<MitraProductResponse> mitraProduct(
            @Header("token") String token
    );

    @GET("product-category")
    Call<CategoryResponse> category();

    @Multipart
    @POST("product")
    Call<DefaultResponse> productStore(
            @Header("token") String auth,
            @Part("title") String title,
            @Part("category_id") int category_id,
            @Part("price") int price,
            @Part("stock") int stock,
            @Part MultipartBody.Part thumbnail,
            @Part("description") String description
    );

    @GET("my-order")
    Call<ShopResponse> myOrder(
            @Header("token") String token
    );

    @GET("my-product-order")
    Call<MitraInvoiceResponse> mitraInvoice(
            @Header("token") String token
    );

    @GET("recycle-category")
    Call<TrashSellingResponse> trashSelling(
            @Header("token") String token
    );

    @GET("my-recycle-order")
    Call<TrashHistoryResponse> getTrashHistory(
            @Header("token") String token
    );

    @FormUrlEncoded
    @POST("recycle")
    Call<DefaultResponse> sell(
            @Header("token") String token,
            @Field("total_price") int total_price,
            @Field("total_weight") int total_weight
    );

    @FormUrlEncoded
    @POST("confirm-order")
    Call<DefaultResponse> confirmResi(
            @Header("token") String token,
            @Field("order_id") int order_id,
            @Field("resi") String resi
    );

    @FormUrlEncoded
    @POST("confirm-order-buyer")
    Call<DefaultResponse> confirmBuyer(
            @Header("token") String token,
            @Field("order_id") int order_id
    );
}
