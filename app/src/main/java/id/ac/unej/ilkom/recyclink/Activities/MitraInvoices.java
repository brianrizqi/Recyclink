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
import id.ac.unej.ilkom.recyclink.Others.TinyDB;
import id.ac.unej.ilkom.recyclink.R;
import id.ac.unej.ilkom.recyclink.Responses.MitraInvoiceResponse;
import id.ac.unej.ilkom.recyclink.Service.Service;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MitraInvoices extends AppCompatActivity {
    @BindView(R.id.rvMitraInvoices)
    RecyclerView rvMitraInvoices;
    List<MitraInvoice> list = new ArrayList<>();
    MitraInvoiceAdapter adapter;
    TinyDB tinyDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mitra_invoices);
        ButterKnife.bind(this);
        tinyDB = new TinyDB(this);
        rvMitraInvoices.setLayoutManager(new LinearLayoutManager(this));
        rvMitraInvoices.setHasFixedSize(true);
        invoice(tinyDB.getString("token"));
    }

    private void invoice(String token) {
        Call<MitraInvoiceResponse> call = Service
                .getInstance()
                .getAPI()
                .mitraInvoice(token);
        call.enqueue(new Callback<MitraInvoiceResponse>() {
            @Override
            public void onResponse(Call<MitraInvoiceResponse> call, Response<MitraInvoiceResponse> response) {
                list = response.body().getData();
                adapter = new MitraInvoiceAdapter(getApplicationContext(), list);
                rvMitraInvoices.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<MitraInvoiceResponse> call, Throwable t) {

            }
        });
    }
}
