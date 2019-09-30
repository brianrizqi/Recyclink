package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Adapter.TrashSellingAdapter;
import id.ac.unej.ilkom.recyclink.R;

public class TrashSelling extends AppCompatActivity {
    @BindView(R.id.rvTrashSelling)
    RecyclerView rvTrashSelling;
    List<id.ac.unej.ilkom.recyclink.Models.TrashSelling> list = new ArrayList<>();
    TrashSellingAdapter adapter;
    @BindView(R.id.txtTrashSellingWeight)
    TextView txtTrashSellingWeight;
    @BindView(R.id.txtTrashSellingTotal)
    TextView txtTrashSellingTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trash_selling);
        ButterKnife.bind(this);
        txtTrashSellingWeight.setText("Total Berat : 12/kg");
        txtTrashSellingTotal.setText("Total Harga : Rp. 60.000");
        rvTrashSelling.setLayoutManager(new LinearLayoutManager(this));
        rvTrashSelling.setHasFixedSize(true);
        list.add(new id.ac.unej.ilkom.recyclink.Models.TrashSelling(1, R.mipmap.logo_green, "Judul", "Sampah Pelastik", "12"));
        list.add(new id.ac.unej.ilkom.recyclink.Models.TrashSelling(1, R.mipmap.logo_green, "Judul", "Sampah Pelastik", "12"));
        list.add(new id.ac.unej.ilkom.recyclink.Models.TrashSelling(1, R.mipmap.logo_green, "Judul", "Sampah Pelastik", "12"));
        adapter = new TrashSellingAdapter(this, list);
        rvTrashSelling.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
