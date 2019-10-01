package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Adapter.CategoryDetailAdapter;
import id.ac.unej.ilkom.recyclink.R;

public class CategoryDetail extends AppCompatActivity {
    @BindView(R.id.txtCategoryDetail)
    TextView txtCategoryDetail;
    @BindView(R.id.rvCategoryDetail)
    RecyclerView rvCategoryDetail;
    CategoryDetailAdapter adapter;
    List<id.ac.unej.ilkom.recyclink.Models.CategoryDetail> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        ButterKnife.bind(this);
        if (getIntent().getStringExtra("category").equalsIgnoreCase("shirt")) {
            txtCategoryDetail.setText("Pakaian");
        } else if (getIntent().getStringExtra("category").equalsIgnoreCase("decoration")) {
            txtCategoryDetail.setText("Dekorasi Rumah");
        } else if (getIntent().getStringExtra("category").equalsIgnoreCase("bag")) {
            txtCategoryDetail.setText("Tas");
        } else if (getIntent().getStringExtra("category").equalsIgnoreCase("furniture")) {
            txtCategoryDetail.setText("Furnitur");
        } else if (getIntent().getStringExtra("category").equalsIgnoreCase("accessories")) {
            txtCategoryDetail.setText("Aksesoris");
        } else {
            txtCategoryDetail.setText("Lainnya");
        }
        rvCategoryDetail.setLayoutManager(new GridLayoutManager(this, 2));
        rvCategoryDetail.setHasFixedSize(true);
        list.add(new id.ac.unej.ilkom.recyclink.Models.CategoryDetail(1, R.mipmap.logo_green, "Judul", "10.000", "5", "Lorem", "Daya Sakti"));
        list.add(new id.ac.unej.ilkom.recyclink.Models.CategoryDetail(1, R.mipmap.logo_green, "Judul", "10.000", "3", "Lorem", "Daya Sakti"));
        list.add(new id.ac.unej.ilkom.recyclink.Models.CategoryDetail(1, R.mipmap.logo_green, "Judul", "10.000", "5", "Lorem", "Daya Sakti"));
        adapter = new CategoryDetailAdapter(this, list);
        rvCategoryDetail.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
