package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Adapter.TrashHistoryAdapter;
import id.ac.unej.ilkom.recyclink.Others.TinyDB;
import id.ac.unej.ilkom.recyclink.R;
import id.ac.unej.ilkom.recyclink.Responses.TrashHistoryResponse;
import id.ac.unej.ilkom.recyclink.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TrashHistory extends AppCompatActivity {
    @BindView(R.id.rvTrashHistory)
    RecyclerView rvTrashHistory;
    TrashHistoryAdapter adapter;
    List<id.ac.unej.ilkom.recyclink.Models.TrashHistory> list = new ArrayList<>();
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trash_history);
        ButterKnife.bind(this);
        tinyDB = new TinyDB(this);
        rvTrashHistory.setLayoutManager(new LinearLayoutManager(this));
        rvTrashHistory.setHasFixedSize(true);
        trashHistory(tinyDB.getString("token"));
    }

    private void trashHistory(String token) {
        Call<TrashHistoryResponse> call = Service
                .getInstance()
                .getAPI()
                .getTrashHistory(token);
        call.enqueue(new Callback<TrashHistoryResponse>() {
            @Override
            public void onResponse(Call<TrashHistoryResponse> call, Response<TrashHistoryResponse> response) {
                list = response.body().getData();
                adapter = new TrashHistoryAdapter(getApplicationContext(), list);
                rvTrashHistory.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<TrashHistoryResponse> call, Throwable t) {

            }
        });
    }
}
