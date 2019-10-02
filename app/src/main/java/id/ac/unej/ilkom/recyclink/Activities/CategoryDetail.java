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
import id.ac.unej.ilkom.recyclink.Models.MitraProduct;
import id.ac.unej.ilkom.recyclink.Models.ProductCategoryResponse;
import id.ac.unej.ilkom.recyclink.Others.TinyDB;
import id.ac.unej.ilkom.recyclink.R;
import id.ac.unej.ilkom.recyclink.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryDetail extends AppCompatActivity {
    @BindView(R.id.txtCategoryDetail)
    TextView txtCategoryDetail;
    @BindView(R.id.rvCategoryDetail)
    RecyclerView rvCategoryDetail;
    CategoryDetailAdapter adapter;
    List<MitraProduct> list = new ArrayList<>();

    private static final String TAG = CategoryDetail.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        ButterKnife.bind(this);
        int category = (int) getIntent().getIntExtra("category", 1);
        switch (category) {
            case 1:
                txtCategoryDetail.setText("Pakaian");
                break;
            case 2:
                txtCategoryDetail.setText("Dekorasi Rumah");
                break;
            case 3:
                txtCategoryDetail.setText("Tas");
                break;
            case 4:
                txtCategoryDetail.setText("Furnitur");
                break;
            case 5:
                txtCategoryDetail.setText("Aksesoris");
                break;
            case 6:
                txtCategoryDetail.setText("Lainnya");
                break;
        }
        getData(category);
    }

    private void getData(int category) {
        rvCategoryDetail.setLayoutManager(new GridLayoutManager(this, 2));
        rvCategoryDetail.setHasFixedSize(true);
        String token = (new TinyDB(this)).getString("token");
        Call<ProductCategoryResponse> call = Service
                .getInstance()
                .getAPI()
                .productCategory(token, category + "");
        call.enqueue(new Callback<ProductCategoryResponse>() {
            @Override
            public void onResponse(Call<ProductCategoryResponse> call, Response<ProductCategoryResponse> response) {
                list = response.body().getData();
                adapter = new CategoryDetailAdapter(getApplicationContext());
                rvCategoryDetail.setAdapter(adapter);
                adapter.setList(list);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ProductCategoryResponse> call, Throwable t) {

            }
        });
    }
}
