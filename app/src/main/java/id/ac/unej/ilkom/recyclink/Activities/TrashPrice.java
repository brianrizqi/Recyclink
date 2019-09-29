package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Adapter.TrashPriceAdapter;
import id.ac.unej.ilkom.recyclink.Models.Trash;
import id.ac.unej.ilkom.recyclink.R;

public class TrashPrice extends AppCompatActivity {
    @BindView(R.id.rvTrashPrice)
    RecyclerView rvTrashPrice;
    TrashPriceAdapter adapter;
    List<Trash> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trash_price);
        ButterKnife.bind(this);
        rvTrashPrice.setLayoutManager(new LinearLayoutManager(this));
        rvTrashPrice.setHasFixedSize(true);
        list.add(new Trash(1, R.mipmap.logo_green, "Aqua", "Sampah Plastik", "5000"));
        list.add(new Trash(1, R.mipmap.logo_green, "Aqua", "Sampah Plastik", "5000"));
        list.add(new Trash(1, R.mipmap.logo_green, "Aqua", "Sampah Plastik", "5000"));
        adapter = new TrashPriceAdapter(this, list);
        rvTrashPrice.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
