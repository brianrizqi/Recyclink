package id.ac.unej.ilkom.recyclink.Service;


import java.io.File;

import id.ac.unej.ilkom.recyclink.Responses.CategoryResponse;
import id.ac.unej.ilkom.recyclink.Responses.DashboardPopulerResponse;
import id.ac.unej.ilkom.recyclink.Responses.DefaultResponse;
import id.ac.unej.ilkom.recyclink.Responses.LoginResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;

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

    @GET("product-category")
    Call<CategoryResponse> category();

    @Multipart
    @FormUrlEncoded
    @POST("product")
    Call<DefaultResponse> productStore(
            @Header("token") String auth,
            @Field("title") String title,
            @Field("category_id") int category_id,
            @Field("price") String price,
            @Field("stock") String stock,
            @Field("thumbnail") String thumbnail,
            @Field("description") String description
    );
}
