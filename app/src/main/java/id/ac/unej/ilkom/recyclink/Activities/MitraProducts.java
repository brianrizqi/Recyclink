package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Adapter.MitraProductAdapter;
import id.ac.unej.ilkom.recyclink.Models.MitraProduct;
import id.ac.unej.ilkom.recyclink.R;

public class MitraProducts extends AppCompatActivity {
    @BindView(R.id.rvMitraProducts)
    RecyclerView rvMitraProducts;
    MitraProductAdapter adapter;
    List<MitraProduct> list = new ArrayList<>();
    @BindView(R.id.fabProduct)
    FloatingActionButton fabProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitra_products);
        ButterKnife.bind(this);
        rvMitraProducts.setLayoutManager(new LinearLayoutManager(this));
        rvMitraProducts.setHasFixedSize(true);
        list.add(new MitraProduct(1, R.mipmap.logo_green, "Judul", "baju", "10.000"));
        list.add(new MitraProduct(1, R.mipmap.logo_green, "Judul", "baju", "10.000"));
        list.add(new MitraProduct(1, R.mipmap.logo_green, "Judul", "baju", "10.000"));
        adapter = new MitraProductAdapter(this, list);
        rvMitraProducts.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        fabProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MitraProducts.this, MitraCreateProduct.class);
                startActivity(i);
            }
        });
    }
}
