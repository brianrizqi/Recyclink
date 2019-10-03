package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Adapter.TrashSellingAdapter;
import id.ac.unej.ilkom.recyclink.Others.TinyDB;
import id.ac.unej.ilkom.recyclink.R;
import id.ac.unej.ilkom.recyclink.Responses.DefaultResponse;
import id.ac.unej.ilkom.recyclink.Responses.TrashSellingResponse;
import id.ac.unej.ilkom.recyclink.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrashSelling extends AppCompatActivity {
    private static final String TAG = TrashSelling.class.getSimpleName();
    @BindView(R.id.rvTrashSelling)
    RecyclerView rvTrashSelling;
    List<id.ac.unej.ilkom.recyclink.Models.TrashSelling> list = new ArrayList<>();
    TrashSellingAdapter adapter;
    @BindView(R.id.txtTrashSellingWeight)
    TextView txtTrashSellingWeight;
    @BindView(R.id.txtTrashSellingTotal)
    TextView txtTrashSellingTotal;
    TinyDB tinyDB;
    @BindView(R.id.btnSell)
    RelativeLayout btnSell;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trash_selling);
        ButterKnife.bind(this);
        tinyDB = new TinyDB(this);
        rvTrashSelling.setLayoutManager(new LinearLayoutManager(this));
        rvTrashSelling.setHasFixedSize(true);
        trashSelling(tinyDB.getString("token"));
        btnSell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sell(tinyDB.getString("token"));
            }
        });
    }

    private void sell(String token) {
        int total_price = Integer.parseInt(txtTrashSellingTotal.getText().toString());
        int total_weight = Integer.parseInt(txtTrashSellingWeight.getText().toString());
        Call<DefaultResponse> call = Service
                .getInstance()
                .getAPI()
                .sell(
                        token,
                        total_price,
                        total_weight
                );
        call.enqueue(new Callback<DefaultResponse>() {
            @Override
            public void onResponse(Call<DefaultResponse> call, Response<DefaultResponse> response) {
                Log.d(TAG, "onResponse: " + response.body());
                if (response.isSuccessful()) {
                    Toast.makeText(TrashSelling.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    onBackPressed();
                    finish();
                }
            }

            @Override
            public void onFailure(Call<DefaultResponse> call, Throwable t) {

            }
        });
    }

    private void trashSelling(String token) {
        Call<TrashSellingResponse> call = Service
                .getInstance()
                .getAPI()
                .trashSelling(token);
        call.enqueue(new Callback<TrashSellingResponse>() {
            @Override
            public void onResponse(Call<TrashSellingResponse> call, Response<TrashSellingResponse> response) {
                list = response.body().getData();
                adapter = new TrashSellingAdapter(getApplicationContext(), list, txtTrashSellingWeight, txtTrashSellingTotal);
                rvTrashSelling.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TrashSellingResponse> call, Throwable t) {

            }
        });
    }
}
