package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Adapter.MitraProductAdapter;
import id.ac.unej.ilkom.recyclink.Models.MitraProduct;
import id.ac.unej.ilkom.recyclink.Others.TinyDB;
import id.ac.unej.ilkom.recyclink.R;
import id.ac.unej.ilkom.recyclink.Responses.MitraProductResponse;
import id.ac.unej.ilkom.recyclink.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MitraProducts extends AppCompatActivity {
    @BindView(R.id.rvMitraProducts)
    RecyclerView rvMitraProducts;
    MitraProductAdapter adapter;
    List<MitraProduct> list = new ArrayList<>();
    @BindView(R.id.fabProduct)
    FloatingActionButton fabProduct;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitra_products);
        ButterKnife.bind(this);
        tinyDB = new TinyDB(this);
        rvMitraProducts.setLayoutManager(new LinearLayoutManager(this));
        rvMitraProducts.setHasFixedSize(true);
        getProduct();
        fabProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MitraProducts.this, MitraCreateProduct.class);
                startActivity(i);
            }
        });
    }

    private void getProduct() {
        Call<MitraProductResponse> call = Service
                .getInstance()
                .getAPI()
                .mitraProduct(
                        tinyDB.getString("token")
                );
        call.enqueue(new Callback<MitraProductResponse>() {
            @Override
            public void onResponse(Call<MitraProductResponse> call, Response<MitraProductResponse> response) {
                if (response.isSuccessful()) {
                    list = response.body().getData();
                    adapter = new MitraProductAdapter(MitraProducts.this, list);
                    rvMitraProducts.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } else {
                    Toast.makeText(MitraProducts.this, response.message(), Toast.LENGTH_SHORT).show();
                    onBackPressed();
                }
            }

            @Override
            public void onFailure(Call<MitraProductResponse> call, Throwable t) {
                Toast.makeText(MitraProducts.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
