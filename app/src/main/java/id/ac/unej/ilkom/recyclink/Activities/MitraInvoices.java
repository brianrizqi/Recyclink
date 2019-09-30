package id.ac.unej.ilkom.recyclink.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import id.ac.unej.ilkom.recyclink.Adapter.MitraInvoiceAdapter;
import id.ac.unej.ilkom.recyclink.Models.MitraInvoice;
import id.ac.unej.ilkom.recyclink.R;

public class MitraInvoices extends AppCompatActivity {
    @BindView(R.id.rvMitraInvoices)
    RecyclerView rvMitraInvoices;
    List<MitraInvoice> list = new ArrayList<>();
    MitraInvoiceAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitra_invoices);
        ButterKnife.bind(this);
        rvMitraInvoices.setLayoutManager(new LinearLayoutManager(this));
        rvMitraInvoices.setHasFixedSize(true);
        list.add(new MitraInvoice(1, "Miko", "Jember", "20 Oktober 2019", 0));
        list.add(new MitraInvoice(1, "Miko", "Jember", "20 Oktober 2019", 1));
        list.add(new MitraInvoice(1, "Miko", "Jember", "20 Oktober 2019", 2));
        adapter = new MitraInvoiceAdapter(this, list);
        rvMitraInvoices.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}
