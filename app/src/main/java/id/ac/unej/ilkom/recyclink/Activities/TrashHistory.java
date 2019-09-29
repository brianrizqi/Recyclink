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
import id.ac.unej.ilkom.recyclink.R;

public class TrashHistory extends AppCompatActivity {
    @BindView(R.id.rvTrashHistory)
    RecyclerView rvTrashHistory;
    TrashHistoryAdapter adapter;
    List<id.ac.unej.ilkom.recyclink.Models.TrashHistory> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trash_history);
        ButterKnife.bind(this);
        rvTrashHistory.setLayoutManager(new LinearLayoutManager(this));
        rvTrashHistory.setHasFixedSize(true);
        list.add(new id.ac.unej.ilkom.recyclink.Models.TrashHistory(1, "3 Oktober 2019", "2", "10.000"));
        list.add(new id.ac.unej.ilkom.recyclink.Models.TrashHistory(1, "3 Oktober 2019", "2", "10.000"));
        list.add(new id.ac.unej.ilkom.recyclink.Models.TrashHistory(1, "3 Oktober 2019", "2", "10.000"));
        adapter = new TrashHistoryAdapter(this, list);
        rvTrashHistory.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
