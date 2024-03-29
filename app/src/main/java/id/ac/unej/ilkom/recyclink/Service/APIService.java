package id.ac.unej.ilkom.recyclink.Service;


import org.w3c.dom.Text;

import java.io.File;

import id.ac.unej.ilkom.recyclink.Models.CategoryDetail;
import id.ac.unej.ilkom.recyclink.Models.ProductCategoryResponse;
import id.ac.unej.ilkom.recyclink.Responses.CategoryResponse;
import id.ac.unej.ilkom.recyclink.Responses.DashboardPopulerResponse;
import id.ac.unej.ilkom.recyclink.Responses.DefaultResponse;
import id.ac.unej.ilkom.recyclink.Responses.LoginResponse;
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

    @GET("fav-products")
    Call<DashboardPopulerResponse> dashboardPopuler(
            @Header("token") String token
    );

    @FormUrlEncoded
    @POST("get-product-by-category")
    Call<ProductCategoryResponse> productCategory(
            @Header("token") String token,
            @Field("category_id") String category
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
}
